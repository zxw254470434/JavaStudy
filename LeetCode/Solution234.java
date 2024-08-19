public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        StringBuilder res = new StringBuilder();
        ListNode p = head;
        while (p != null) {
            res.append(p.val);
            p = p.next;
        }
        if (!res.toString().equals(res.reverse().toString())) {
            return false;
        }
        return true;
    }
}
