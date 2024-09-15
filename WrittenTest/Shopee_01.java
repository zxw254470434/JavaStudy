import java.time.LocalDate;
import java.util.*;

public class Shopee_01 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param merchant_list string字符串 一维数组
     * @return string字符串一维数组
     */
    public String[] merchant_verify(String[] merchant_list) {
        // write code here
        int n = merchant_list.length;
        String[] res = new String[n];

        Set<String> countries = new HashSet<>();
        countries.add("SG");
        countries.add("PH");
        countries.add("ID");
        countries.add("MY");

        for (int i = 0; i < n; i++) {
            String store = merchant_list[i];
            if (store.length() != 14) {
                res[i] = "FAILED";
                continue;
            }
            String country = store.substring(0, 2);
            String date = store.substring(2, 10);
            String id = store.substring(10, 13);
            int x = Integer.parseInt(store.substring(13, 14));
            if (!countries.contains(country)) {
                res[i] = "FAILED";
                continue;
            }
            if (!isValidData(date)) {
                res[i] = "FAILED";
                continue;
            }
            if (id.charAt(0) == id.charAt(1) && id.charAt(1) == id.charAt(2)) {
                res[i] = "FAILED";
                continue;
            }
            int sum = x;
            for (int j = 2; j <= 12; j++) {
                sum += Integer.parseInt(String.valueOf(store.charAt(j)));
            }
            if (sum % 8 != 1) {
                res[i] = "FAILED";
                continue;
            }
            res[i] = "PASS";
        }
        return res;
    }

    public boolean isValidData(String originalDate) {
        int year = Integer.parseInt(originalDate.substring(0, 4));
        int month = Integer.parseInt(originalDate.substring(4, 6));
        int day = Integer.parseInt(originalDate.substring(6, 8));
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] days2 = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (year < 1990 || year > 2099) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            if (day < 1 || day > days2[month - 1]) {
                return false;
            }
        } else {
            if (day < 1 || day > days[month - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Shopee_01 shopee = new Shopee_01();
        String[] input = new String[]{"MY200012241230", "CN200012241230", "MY200012241235", "SG202113141235"};
        String[] res = shopee.merchant_verify(input);
        for (String r : res) {
            System.out.println(r);
        }
    }
}
