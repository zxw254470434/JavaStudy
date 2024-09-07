import java.util.Scanner;

/**
 * 美团2024年春招第一场笔试【测试方向】
 * <a href="https://www.nowcoder.com/exam/test/82233439/detail?pid=55750581&pageSource=testHistory">...</a>
 * 第 2 题：小美的数组询问
 */
public class MeiTuan_Spring_Test_24_01_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int flag = 0;
        long sum = 0;


        //并不需要存储nums数组
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            if (x != 0) sum += x;
            else flag++;
        }

        for (int i = 0; i < q; i++) {
            long left = sc.nextLong();
            long right = sc.nextLong();
            System.out.println((sum + left * flag) + " " + (sum + right * flag));
        }
        sc.close();
    }
}
