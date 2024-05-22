public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummyLower = new ListNode(-1);
        ListNode dummyGreater = new ListNode(-1);
        ListNode lower = dummyLower;
        ListNode grater = dummyGreater;

        ListNode list = head;
        while (list != null) {
            if (list.val < x) {
                lower.next = list;
                lower = lower.next;
            } else {
                grater.next = list;
                grater = grater.next;
            }
            ListNode temp=list.next;
            list.next=null;
            list=temp;
        }
        lower.next = dummyGreater.next;

        return dummyLower.next;
    }
}
