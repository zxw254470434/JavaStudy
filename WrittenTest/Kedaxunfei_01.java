import java.util.Scanner;

public class Kedaxunfei_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        double result = ((x + y) / 2.0) * (n - 1);

        String formatResult = String.format("%.1f", result);
        System.out.println(formatResult);
    }
}
