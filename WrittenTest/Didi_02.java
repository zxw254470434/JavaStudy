import java.util.*;

public class Didi_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n + 1];
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + a[i];
        }

        int maxCount = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (preSum[j] - preSum[i - 1] <= m) {
                    maxCount = Math.max(maxCount, j - i + 1);
                } else {
                    break;
                }
            }
        }
        System.out.println(maxCount);
    }
}
