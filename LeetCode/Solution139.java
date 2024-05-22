import java.util.List;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        //dp[i]表示 s 的前 i 位是否可以用 wordDict 中的单词表示。
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                if (word.length() + i <= length && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[length];
    }
}
