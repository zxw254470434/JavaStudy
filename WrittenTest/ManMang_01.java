import java.util.*;

public class ManMang_01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param lists ListNode类一维数组
     * @return ListNode类ArrayList
     */
    public ArrayList<ListNode> sortList(ListNode[] lists) {
        // write code here
        Arrays.sort(lists, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                ListNode a = (ListNode) o1;
                ListNode b = (ListNode) o2;
                while (a != null && b != null) {
                    if (a.val < b.val) {
                        return -1;
                    } else if (a.val > b.val) {
                        return 1;
                    }
                    a = a.next;
                    b = b.next;
                }
                if (a == null && b == null) {
                    return 0;
                } else if (a == null) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        ArrayList<ListNode> res = new ArrayList<>();
        for (ListNode l : lists) {
            res.add(l);
        }
        return res;
    }

}