import java.util.Arrays;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        boolean firstColHasObstacle = false;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) firstColHasObstacle = true;
            dp[i][0] = firstColHasObstacle ? 0 : 1;
        }
        boolean firstRowHasObstacle = false;
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) firstRowHasObstacle = true;
            dp[0][j] = firstRowHasObstacle ? 0 : 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
