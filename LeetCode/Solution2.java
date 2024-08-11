public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode num1 = l1, num2 = l2, p = dummy;
        int carry = 0, temp = 0, local = 0;
        while (num1 != null && num2 != null) {
            temp = num1.val + num2.val + carry;
            local = temp % 10;
            carry = temp / 10;
            p.next = new ListNode(local);

            p = p.next;
            num1 = num1.next;
            num2 = num2.next;
        }
        while (num1 != null) {
            temp = num1.val + carry;
            local = temp % 10;
            carry = temp / 10;
            p.next = new ListNode(local);
            p = p.next;
            num1 = num1.next;
        }
        while (num2 != null) {
            temp = num2.val + carry;
            local = temp % 10;
            carry = temp / 10;
            p.next = new ListNode(local);
            p = p.next;
            num2 = num2.next;
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
