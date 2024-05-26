public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA, q = headB;
        while (p != q) {
            if (p == null) p = headB;
            else p = p.next;

            if (q == null) q = headA;
            else q = q.next;
        }
        return p;
    }
}
