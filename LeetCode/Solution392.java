public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int length_s = s.length();
        int length_t = t.length();
        int i = 0, j = 0;
        while (i < length_s) {
            while (j < length_t && s.charAt(i) != t.charAt(j)) j++;
            if (j == length_t) {
                return false;
            } else if (j == length_t - 1 && i < length_s - 1) {
                return false;
            } else if (j == length_t - 1 && i == length_s - 1) {
                return true;
            } else if (j < length_t - 1 && i < length_s) {
                i++;
                j++;
            }
        }
        return true;
    }
}
