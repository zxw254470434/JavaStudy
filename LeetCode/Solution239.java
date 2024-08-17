import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口最大值 ，使用 单调队列
 * <a href="https://leetcode.cn/problems/sliding-window-maximum/solutions/2499715/shi-pin-yi-ge-shi-pin-miao-dong-dan-diao-ezj6/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>(); // 双端队列
        for (int i = 0; i < n; i++) {
            // 1. 入
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast(); // 维护 q 的单调性
            }
            q.addLast(i); // 入队
            // 2. 出
            if (i - q.getFirst() >= k) { // 队首已经离开窗口了
                q.removeFirst();
            }
            // 3. 记录答案
            if (i >= k - 1) {
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                ans[i - k + 1] = nums[q.getFirst()];
            }
        }
        return ans;
    }
}
