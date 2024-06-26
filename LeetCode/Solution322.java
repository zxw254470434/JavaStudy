import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution322 {

    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];

        Arrays.fill(memo, -999);

        return dp(coins, amount);
    }

    int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (memo[amount] != -999) return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);

            if (subProblem == -1) continue;

            res = Math.min(res, subProblem + 1);
        }

        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }
}
