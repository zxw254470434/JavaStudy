import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    List<String> res = new ArrayList<>();
    String digits;
    Map<Character, String> phoneMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if (digits.length() == 0) {
            return res;
        }
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        backtrack(0, new StringBuilder());
        return res;
    }

    void backtrack(int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
        }else {
            char c=digits.charAt(index);
            String letters = phoneMap.get(c);
            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));
                backtrack(index + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
