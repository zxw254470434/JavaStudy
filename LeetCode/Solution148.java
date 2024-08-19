import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        /**
         * Comparator.comparingInt(n -> n.val)：
         * 这是一个静态方法，它接收一个从对象中提取整数值的函数（这里是 n -> n.val），
         * 并返回一个 Comparator，这个 Comparator 会按整数值从小到大进行排序。
         */
        list.sort(Comparator.comparingInt(n -> n.val));

        ListNode dummy = new ListNode(-1);
        p = dummy;
        for (ListNode n : list) {
            p.next = n;
            p = p.next;
        }
        p.next = null;
        return dummy.next;
    }
}
