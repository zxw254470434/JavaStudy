public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }

    /**
     * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/solutions/575549/shua-chuan-lc-jian-ji-shuang-zhi-zhen-ji-2eg8/?envType=study-plan-v2&envId=top-interview-150">...</a>
     */
    public int removeDuplicates2(int[] nums) {
        return process(nums, 1);
    }

    int process(int[] nums, int k) {
        int idx = 0;
        for (int x : nums) {
            if (idx < k || nums[idx - k] != x) nums[idx++] = x;
        }
        return idx;
    }
}
