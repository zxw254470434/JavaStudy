public class Solution151 {
    public String reverseWords(String s) {
        int length = s.length();
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                if (word.toString().equals("")) {
                    continue;
                } else {
                    res.insert(0, ' ');
                    res.insert(0, word);
                    word = new StringBuilder();
                }
            } else {
                word.append(s.charAt(i));
            }
        }
        if (!word.toString().equals("")) {
            res.insert(0, ' ');
            res.insert(0, word);
        }
        res.deleteCharAt(res.length() - 1);

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        String res = new Solution151().reverseWords(s);
        System.out.println("res = " + res);
    }
}
