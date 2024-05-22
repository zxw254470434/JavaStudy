public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        int length = strs[0].length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (s.length() < i + 1 || s.charAt(i) != c) {
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }
}
