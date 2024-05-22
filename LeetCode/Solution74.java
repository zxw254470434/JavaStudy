public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] firstCol = new int[m];
        for (int i = 0; i < m; i++) {
            firstCol[i] = matrix[i][0];
        }
        int up = 0;
        int down = m - 1;
        while (up <= down) {
            int mid = up + (down - up) / 2;
            if (firstCol[mid] == target) {
                return true;
            } else if (firstCol[mid] < target) {
                up = mid + 1;
            } else if (firstCol[mid] > target) {
                down = mid - 1;
            }
        }
        if (down < 0 || down >= m) return false;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[down][mid] == target) {
                return true;
            } else if (matrix[down][mid] < target) {
                left = mid + 1;
            } else if (matrix[down][mid] > target) {
                right = mid - 1;
            }
        }
        return false;
    }
}
