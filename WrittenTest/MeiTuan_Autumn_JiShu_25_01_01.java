import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MeiTuan_Autumn_JiShu_25_01_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine(); // 读取并丢弃nextInt()留下的换行符
        String correctPassword = in.nextLine();
        int length = correctPassword.length();
        // 检测输入中是否有正确的密码
//        boolean hasCorrectPassword = false;
        // 记录长度小于 length 且不重复的字符串的个数
        int count = 0;
        Set<String> set = new HashSet<String>();
        // 记录记录长度等于 length 且不重复的字符串的个数
        int count2 = 0;
        Set<String> set2 = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            String tempPassword = in.nextLine();
            if (tempPassword.length() < length && !set.contains(tempPassword)) {
                count++;
                set.add(tempPassword);
            } else if (tempPassword.length() == length) {
//                if (tempPassword.equals(correctPassword)) {
//                    hasCorrectPassword = true;
//                }
                if (!set2.contains(tempPassword)) {
                    count2++;
                    set2.add(tempPassword);
                }
            }
        }
        System.out.print((count + 1) + " " + (count + count2));
    }
}
