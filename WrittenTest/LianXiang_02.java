import java.util.Scanner;

/**
 * 已知工厂未来 n 天工作情况，机器热量最高为T，最低为0。
 * 第 i 天启动机器，热量增加 ai，收益增加 bi；不启动，热量减少 ci。
 * 求最大收益。
 */
public class LianXiang_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int T = in.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        int[] c = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            c[i] = in.nextInt();
        }

        int[][] dp = new int[n + 1][T + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= T; j++) {
                if (dp[i - 1][j] != -1) {
                    int newHeat = Math.max(0, j - c[i]);
                    dp[i][newHeat] = Math.max(dp[i][newHeat], dp[i - 1][j]);

                    if (j + a[i] <= T) {
                        dp[i][j + a[i]] = Math.max(dp[i][j + a[i]], dp[i - 1][j] + b[i]);
                    }
                }
            }
        }

        int maxProfit = 0;
        for (int j = 0; j <= T; j++) {
            maxProfit = Math.max(maxProfit, dp[n][j]);
        }
        System.out.println(maxProfit);
    }
}
