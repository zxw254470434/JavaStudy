import java.util.Scanner;

public class MeiTuan_Autumn_Test_25_04_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String orderId = in.nextLine();
            if (orderId.length() != 15) {
                System.out.println("invalid");
                continue;
            }

            String prefix = orderId.substring(0, 3);
            String date = orderId.substring(3, 11);
            String num = orderId.substring(11, 15);
            if (!isAllUpperCase(prefix)) {
                System.out.println("invalid");
                continue;
            }
            if (!isValidDate(date)) {
                System.out.println("invalid");
                continue;
            }
            if (!isAllDigit(num)) {
                System.out.println("invalid");
                continue;
            }
            System.out.println("valid");
        }
    }

    public static boolean isAllUpperCase(String prefix) {
        return prefix.matches("[A-Z]+");
    }

    public static boolean isValidDate(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));
        if (month < 1 || month > 12) {
            return false;
        }
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 闰年
        int[] days_run = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return day >= 1 && day <= days_run[month - 1];
        } else {
            return day >= 1 && day <= days[month - 1];
        }
    }

    public static boolean isAllDigit(String num) {
        return num.matches("[0-9]+");
    }
}
