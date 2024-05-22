public class Solution70 {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int i_2 = 1, i_1 = 1;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = i_2 + i_1;
            i_2 = i_1;
            i_1 = curr;
        }
        return curr;
    }
}
