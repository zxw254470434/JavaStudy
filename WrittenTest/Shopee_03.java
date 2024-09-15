public class Shopee_03 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param sequence string字符串
     * @return int整型
     */
    public int longest_sequence(String sequence) {
        // write code here
        int n = sequence.length();
        if (n <= 1) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence.charAt(j) != sequence.charAt(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Shopee_03 s = new Shopee_03();
        System.out.println(s.longest_sequence("0100101010111"));
    }
}
