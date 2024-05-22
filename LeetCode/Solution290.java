import java.util.HashMap;
import java.util.Map;

public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Character, String> p2w = new HashMap<>();
        Map<String, Character> w2p = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);
            String b = words[i];

            if (p2w.containsKey(a) && !p2w.get(a).equals(b) ||
                    w2p.containsKey(b) && !w2p.get(b).equals(a)) {
                return false;
            }

            p2w.put(a, b);
            w2p.put(b, a);
        }

        return true;
    }
}
