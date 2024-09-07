import java.util.Scanner;

public class Xiaomi_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int mintime = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    mintime = Math.min(mintime, a[i] + b[j]);
                    continue;
                }

                int t1 = Math.max(a[i], b[j]);
                int t2 = a[i] + b[j];

                int ctime = Math.min(t1, t2);
                mintime = Math.min(mintime, ctime);
            }
        }
        System.out.println(mintime);
    }
}
