public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String num = String.valueOf(x);
        int left = 0, right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0)
            return false;
        int n = x;
        int cur = 0;
        while (n != 0) {
            cur = cur * 10 + n % 10;
            n = n / 10;
        }
        return cur == x;
    }
}
