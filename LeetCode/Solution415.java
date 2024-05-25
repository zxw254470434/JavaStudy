public class Solution415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int temp = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            carry = temp / 10;
            res.insert(0, temp % 10);
            i--;
            j--;
        }
        while (i >= 0) {
            int temp = num1.charAt(i) - '0' + carry;
            carry = temp / 10;
            res.insert(0, temp % 10);
            i--;
        }
        while (j >= 0) {
            int temp = num2.charAt(j) - '0' + carry;
            carry = temp / 10;
            res.insert(0, temp % 10);
            j--;
        }
        if (carry > 0) {
            res.insert(0, carry);
        }
        return res.toString();
    }
}
