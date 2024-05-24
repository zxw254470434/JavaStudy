public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder ss = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (ss.length() > 0) {
                    ss.deleteCharAt(ss.length() - 1);
                }
            }
            else {
                ss.append(c);
            }
        }
        StringBuilder tt = new StringBuilder();
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (tt.length() > 0) {
                    tt.deleteCharAt(tt.length() - 1);
                }
            }else {
                tt.append(c);
            }
        }

        return ss.toString().equals(tt.toString());
    }
}
