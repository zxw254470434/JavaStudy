import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> ((b[0] + b[1]) - (a[0] + a[1])));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (q.size() < k) {
                    q.add(new int[]{nums1[i], nums2[j]});
                } else {
                    if ((nums1[i] + nums2[j]) < (q.peek()[0] + q.peek()[1])) {
                        q.poll();
                        q.add(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        for (int[] nums : q) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            list.add(nums[1]);
            res.add(list);
        }

        return res;
    }
}
