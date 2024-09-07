import java.util.*;

public class TencentMusic_02 {
    public ListNode mergeList(ListNode a, ListNode b) {
        // write code here
        ArrayList<Integer> list_a = new ArrayList<>();
        ArrayList<Integer> list_b = new ArrayList<>();
        ListNode la = a, lb = b;
        while (la != null) {
            list_a.add(la.val);
            la = la.next;
        }
        while (lb != null) {
            list_b.add(lb.val);
            lb = lb.next;
        }

        int len_a = list_a.size();
        int len_b = list_b.size();
        int left = 0;
        for (int i = 0; i < Math.min(len_a, len_b); i++) {
            if (list_a.get(i) == list_b.get(i)) {
                left++;
            } else {
                break;
            }
        }

        Collections.reverse(list_a);
        Collections.reverse(list_b);
        int right = 0;
        for (int i = 0; i < Math.min(len_a, len_b); i++) {
            if (list_a.get(i) == list_b.get(i)) {
                right++;
            } else {
                break;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        cur.next = a;
        cur = cur.next;
        for (int i = 1; i < left; i++) {
            cur = cur.next;
        }
        cur.next = findFromEnd(a, right);

        return dummy.next;
    }

    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
