import java.util.HashMap;

public class Solution13 {
    public int romanToInt(String s) {
        int n = s.length();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        res += map.get(s.charAt(0));
        for (int i = 1; i < n; i++) {
            res += map.get(s.charAt(i));
            if (s.charAt(i) == 'V' && s.charAt(i - 1) == 'I') {
                res = res - 2;
            } else if (s.charAt(i) == 'X' && s.charAt(i - 1) == 'I') {
                res = res - 2;
            } else if (s.charAt(i) == 'L' && s.charAt(i - 1) == 'X') {
                res = res - 20;
            } else if (s.charAt(i) == 'C' && s.charAt(i - 1) == 'X') {
                res = res - 20;
            } else if (s.charAt(i) == 'D' && s.charAt(i - 1) == 'C') {
                res = res - 200;
            } else if (s.charAt(i) == 'M' && s.charAt(i - 1) == 'C') {
                res = res - 200;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        int res = new Solution13().romanToInt(s);
        System.out.println("res = " + res);
    }
}
