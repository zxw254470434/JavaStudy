import java.util.Scanner;

/**
 * 美团2024年春招第一场笔试【测试方向】
 * <a href="https://www.nowcoder.com/exam/test/82233439/detail?pid=55750581&pageSource=testHistory">...</a>
 * 第 1 题：小美的平衡矩阵
 * <a href="https://blog.csdn.net/EANFSKK/article/details/136951349">...</a>
 * 思路：要解决这个问题，我们可以遍历所有可能的矩形区域，并检查每个区域内0和1的数量是否相等。一种方法是使用前缀和。
 * 具体来说，我们可以分别维护0和1的前缀和矩阵，这样就可以在O(1)时间内得到任意矩形区域内0和1的数量。
 * 1、构建前缀和矩阵：分别计算并存储0和1的前缀和。对于矩阵中的每个点(i, j)，prefix_0[i][j]表示左上角(0, 0)到(i, j)形成的矩形区域内0的数量，prefix_1[i][j]同理。
 * 2、遍历所有可能的i*i矩形区域：对于每个可能的边长i（从1到n），遍历矩阵中所有可能的 i * i 的矩形区域。
 * 3、检查矩形区域是否完美：对于每个矩形区域，使用前缀和快速计算区域内0和1的数量，检查它们是否相等。
 * 4、计数并输出结果：对于每个边长 i，计算满足条件的 i * i 的完美矩形区域数量。
 * 缺点：容易超时
 */
public class Spring_Test_24_01_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();  // Matrix size
        int[][] matrix = new int[n][n];  // Read the matrix
        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = row.charAt(j) - '0';
            }
        }

        // Initialize prefix sum matrices
        int[][] prefix0 = new int[n + 1][n + 1];
        int[][] prefix1 = new int[n + 1][n + 1];

        // Compute prefix sums
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefix0[i][j] = prefix0[i - 1][j] + prefix0[i][j - 1] - prefix0[i - 1][j - 1] + (matrix[i - 1][j - 1] == 0 ? 1 : 0);
                prefix1[i][j] = prefix1[i - 1][j] + prefix1[i][j - 1] - prefix1[i - 1][j - 1] + (matrix[i - 1][j - 1] == 1 ? 1 : 0);
            }
        }

        // Count perfect square submatrices
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int x = i; x <= n; x++) {
                for (int y = i; y <= n; y++) {
                    int zeros = prefix0[x][y] - prefix0[x - i][y] - prefix0[x][y - i] + prefix0[x - i][y - i];
                    int ones = prefix1[x][y] - prefix1[x - i][y] - prefix1[x][y - i] + prefix1[x - i][y - i];
                    if (zeros == ones) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

        scanner.close();
    }
}
