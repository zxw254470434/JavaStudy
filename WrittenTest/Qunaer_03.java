import java.util.*;

public class Qunaer_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            g[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            List<int[]> list = fun(i);

            long sum = 0;
            for (int[] yinzi : list) {
                sum += f[yinzi[0]] * g[yinzi[1]];
            }
            sum = (long) (sum % (Math.pow(10,7) + 9));
            System.out.print(sum + " ");
        }
    }

    public static List<int[]> fun(int num) {
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                int n = num / i;
                int[] temp = new int[]{i, n};
                int[] temp2 = new int[]{n, i};

                list.add(temp);
                if (n != i) {
                    list.add(temp2);
                }
            }
        }
        return list;
    }
}
