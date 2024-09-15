public class BiliBili_02 {
    public int F(String x) {
        if (x.isEmpty()) return 0;
        int res = 0;
        int[] dp = new int[x.length()];
        for (int i = 1; i < x.length(); i++) {
            if (x.charAt(i) == ']') {
                if (x.charAt(i - 1) == '[') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && x.charAt(i - dp[i - 1] - 1) == '[') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
