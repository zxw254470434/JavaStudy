public class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, pos = n - 1, right = n - 1;
        int[] res = new int[n];
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[pos] = nums[left] * nums[left];
                left++;
            } else {
                res[pos] = nums[right] * nums[right];
                right--;
            }
            pos--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] res = new Solution977().sortedSquares(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
