public class Solution530 {
    int pre = -1;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }

    void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }
        traverse(root.right);
    }
}
