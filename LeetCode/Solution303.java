public class Solution303 {
    private int[] presum;

    public Solution303(int[] nums) {
        presum = new int[nums.length + 1];
        for (int i = 1; i < presum.length; i++) {
            presum[i] = nums[i - 1] + presum[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return presum[right + 1] - presum[left];
    }
}
