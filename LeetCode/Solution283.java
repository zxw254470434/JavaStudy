public class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
