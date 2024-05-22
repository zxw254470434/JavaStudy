public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return dfs(nums, 0, n - 1);
    }

    private TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, lo, mid - 1);
        root.right = dfs(nums, mid + 1, hi);
        return root;
    }
}
