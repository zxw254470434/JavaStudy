public class BiliBili_01 {
    public boolean F(String x, String y) {
        // write code here
        if (x.isEmpty() || y.isEmpty()) return false;
        int i = 0, j = 0;
        while (j < y.length()) {
            if (i < x.length() && x.charAt(i) == y.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == x.length();
    }

    public static void main(String[] args) {
        BiliBili_01 obj = new BiliBili_01();
        System.out.println(obj.F("ea", "abcde"));
    }
}
