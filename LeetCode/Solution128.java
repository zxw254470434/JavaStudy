import java.util.Arrays;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        Arrays.sort(nums);

        int longest = 0;
        int temp = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                if (i == n - 1) {
                    longest = Math.max(longest, temp + 1);
                }
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                temp++;
                if (i == n - 1) {
                    longest = Math.max(longest, temp + 1);
                }
            } else {
                longest = Math.max(longest, temp + 1);
                temp = 0;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 2};
        int longest = new Solution128().longestConsecutive(nums);
        System.out.println("longest = " + longest);
    }
}
