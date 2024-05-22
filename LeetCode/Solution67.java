public class Solution67 {
    public String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (la != 0 && lb != 0) {
            int lasta = Integer.parseInt(String.valueOf(a.charAt(la - 1)));
            int lastb = Integer.parseInt(String.valueOf(b.charAt(lb - 1)));
            int local = (lasta + lastb + carry) % 2;
            carry = (lasta + lastb + carry) >= 2 ? 1 : 0;
            sb.append(local);
            la--;
            lb--;
        }
        while (la != 0) {
            int lasta = Integer.parseInt(String.valueOf(a.charAt(la - 1)));
            int local = (lasta + carry) % 2;
            carry = (lasta + carry) == 2 ? 1 : 0;
            sb.append(local);
            la--;
        }
        while (lb != 0) {
            int lastb = Integer.parseInt(String.valueOf(b.charAt(lb - 1)));
            int local = (lastb + carry) % 2;
            carry = (lastb + carry) == 2 ? 1 : 0;
            sb.append(local);
            lb--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
