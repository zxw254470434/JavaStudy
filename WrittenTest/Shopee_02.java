public class Shopee_02 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param date string字符串
     * @return int整型
     */
    public int day_of_year(String date) {
        // write code here
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] days2 = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (year < 1 || year > 3000) {
            return 0;
        }
        if (month < 1 || month > 12) {
            return 0;
        }

        int count = 0;
        //闰年
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            if (day < 1 || day > days2[month - 1]) {
                return 0;
            }
            for (int i = 0; i < month - 1; i++) {
                count += days2[i];
            }
            count += day;
        } else {
            if (day < 1 || day > days[month - 1]) {
                return 0;
            }
            for (int i = 0; i < month - 1; i++) {
                count += days[i];
            }
            count += day;
        }

        return count;
    }

    public static void main(String[] args) {
        Shopee_02 shopee = new Shopee_02();
        System.out.println(shopee.day_of_year("20251304"));
    }

}
