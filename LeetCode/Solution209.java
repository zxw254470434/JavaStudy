public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int tempSum = 0;

        while (right < n) {
            tempSum += nums[right];
            right++;

            while (tempSum >= target) {
                minLength = Math.min(minLength, right - left);

                tempSum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int res = new Solution209().minSubArrayLen(7, nums);
        System.out.println("res = " + res);
    }
}
