public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1=cur.next;
            ListNode node2=cur.next.next;

            cur.next=node2;
            node1.next=node2.next;
            node2.next=node1;

            cur=node1;
        }
        return dummy.next;
    }
}
