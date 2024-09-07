import java.util.Scanner;

public class Qunaer_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            char p = sc.next().charAt(0);
            sc.nextLine();
            String str = sc.nextLine();

            boolean flag = false;

            if (str.charAt(m - 1) == p) {
                flag = true;
                System.out.println("Yes");
                break;
            }

            for (int j = m; j < n; j++) {
                if (str.charAt(j) == p) {
                    int distancce = j - (m - 1);
                    if (distancce <= k) {
                        flag = true;
                        System.out.println("Yes");
                        break;
                    }
                }
            }
            if (!flag) {
                System.out.println("No");
            }
        }
    }
}
