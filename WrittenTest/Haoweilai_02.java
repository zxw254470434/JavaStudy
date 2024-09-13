import java.util.*;

public class Haoweilai_02 {
    /**
     * 字符串压缩
     * https://leetcode.cn/problems/compress-string-lcci/description/
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return string字符串
     */
    public String compress_string(String s) {
        // write code here
        int i = 0, j = 0, length = s.length();
        StringBuilder sb = new StringBuilder();
        while (i < length) {
            while (j < length && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            sb.append(s.charAt(i));
            sb.append(j - i);
            i = j;
        }
        return sb.length() < length ? sb.toString() : s;
    }
}
