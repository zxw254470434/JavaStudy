import java.util.HashMap;

public class Solution12 {
    public String intToRoman(int num) {
        StringBuilder s = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        int tempNum = num;
        int tempNum2 = num;
        int length = Integer.toString(tempNum).length();
        for (int i = length; i > 0; i--) {
            int pow = (int) Math.pow(10, i - 1);
            int first = tempNum2 / pow;
            if (pow == 1000) {
                for (int j = 0; j < first; j++) {
                    s.append(map.get(1000));
                }
            } else if (pow == 100) {
                if (first < 4) {
                    for (int j = 0; j < first; j++) {
                        s.append('C');
                    }
                } else if (first == 4) {
                    s.append('C');
                    s.append('D');
                } else if (first == 5) {
                    s.append('D');
                } else if (6 <= first && first <= 8) {
                    s.append('D');
                    for (int j = first - 5; j > 0; j--) {
                        s.append('C');
                    }
                } else if (first == 9) {
                    s.append('C');
                    s.append('M');
                }
            } else if (pow == 10) {
                if (first < 4) {
                    for (int j = 0; j < first; j++) {
                        s.append('X');
                    }
                } else if (first == 4) {
                    s.append('X');
                    s.append('L');
                } else if (first == 5) {
                    s.append('L');
                } else if (6 <= first && first <= 8) {
                    s.append('L');
                    for (int j = first - 5; j > 0; j--) {
                        s.append('X');
                    }
                } else if (first == 9) {
                    s.append('X');
                    s.append('C');
                }
            } else if (pow == 1) {
                if (first < 4) {
                    for (int j = 0; j < first; j++) {
                        s.append('I');
                    }
                } else if (first == 4) {
                    s.append('I');
                    s.append('V');
                } else if (first == 5) {
                    s.append('V');
                } else if (6 <= first && first <= 8) {
                    s.append('V');
                    for (int j = first - 5; j > 0; j--) {
                        s.append('I');
                    }
                } else if (first == 9) {
                    s.append('I');
                    s.append('X');
                }
            }
            tempNum2 -= pow * first;

        }

        return s.toString();
    }

    public static void main(String[] args) {
        int num = 1994;
        String res = new Solution12().intToRoman(num);
        System.out.println("res = " + res);
    }
}
