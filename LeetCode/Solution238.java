public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preMulti = new int[n];
        int[] postMulti = new int[n];
        int[] answer = new int[n];

        preMulti[0] = nums[0];
        postMulti[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            preMulti[i] = preMulti[i - 1] * nums[i];
        }
        for (int i = n - 2; i > -1; i--) {
            postMulti[i] = postMulti[i + 1] * nums[i];
        }

        answer[0] = postMulti[1];
        answer[n - 1] = preMulti[n - 2];
        for (int i = 1; i < n - 1; i++) {
            answer[i] = preMulti[i - 1] * postMulti[i + 1];
        }

        return answer;
    }
}
