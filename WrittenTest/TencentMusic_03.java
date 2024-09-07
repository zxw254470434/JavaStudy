public class TencentMusic_03 {
    public int matrixCount(String[] a, int myval) {
        // write code here
        int n = a.length;
        int[][][] prefixSum = new int[n + 1][n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                char c = a[i - 1].charAt(j - 1);
                int index = (c == 'r') ? 0 : (c == 'e') ? 1 : 2;
                prefixSum[i][j][index] = 1;

                for (int k = 0; k < 3; k++) {
                    prefixSum[i][j][k] += prefixSum[i - 1][j][k] + prefixSum[i][j - 1][k] - prefixSum[i - 1][j - 1][k];
                }
            }
        }
        int count = 0;
        for (int size = 1; size <= n; size++) {
            for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= n - size; j++) {
                    int[] counts = new int[3];
                    for (int k = 0; k < 3; k++) {
                        counts[k] = prefixSum[i + size][j + size][k] - prefixSum[i][j + size][k] - prefixSum[i + size][j][k] + prefixSum[i][j][k];
                    }
                    int minCount = Math.min(counts[0], Math.min(counts[1], counts[2]));
                    if (minCount >= myval) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
