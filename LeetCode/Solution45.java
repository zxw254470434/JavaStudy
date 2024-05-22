public class Solution45 {
    public int jump(int[] nums) {
        int length = nums.length;
        int steps = 0;
        int end = 0;
        int maxPosition = 0;

        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }
}
