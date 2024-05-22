import java.util.Arrays;

public class Solution931_2 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = dp[i - 1][j];
                if (j > 0) temp = Math.min(temp, dp[i - 1][j - 1]);
                if (j < n - 1) temp = Math.min(temp, dp[i - 1][j + 1]);

                dp[i][j] = temp + matrix[i][j];
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }

        return res;
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
