import java.util.HashSet;
import java.util.Scanner;

/**
 * 美团2024年春招第一场笔试【测试方向】
 * <a href="https://www.nowcoder.com/exam/test/82233439/detail?pid=55750581&pageSource=testHistory">...</a>
 * 第 3 题：验证工号
 */
public class MeiTuan_Spring_Test_24_01_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> departments = new HashSet<>();
        for (int i = 0; i < n; i++) {
            departments.add(sc.next());
        }
        int m = sc.nextInt();
        String[] ids = new String[m];
        for (int i = 0; i < m; i++) {
            ids[i] = sc.next();
        }

        for (String id : ids) {
            if (id.length() != 18) {
                System.out.println("error");
                continue;
            }
            if (!departments.contains(id.substring(0, 6))) {
                System.out.println("error");
                continue;
            }
            if (!is_valid_date(id.substring(6, 14))) {
                System.out.println("error");
                continue;
            }
            if (id.charAt(14) == id.charAt(15) && id.charAt(15) == id.charAt(16)) {
                System.out.println("error");
                continue;
            }
            if (!checkSum(id)){
                System.out.println("error");
                continue;
            }
            System.out.println("ok");
        }
    }

    public static boolean is_valid_date(String birthday) {
        int year = Integer.parseInt(birthday.substring(0, 4));
        int month = Integer.parseInt(birthday.substring(4, 6));
        int day = Integer.parseInt(birthday.substring(6, 8));
        if (year < 1900 || year > 2023) {
            return false;
        }
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

    public static boolean checkSum(String id) {
        int sum = 0;
        for (int i = 0; i < id.length(); i++) {
            sum += Character.getNumericValue(id.charAt(i));
        }
        return (sum & 7) == 1;
    }
}
