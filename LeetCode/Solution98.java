public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;

        return helper(root.left, min, root) && helper(root.right, root, max);
    }

    int pre = Integer.MIN_VALUE;
    boolean flag = true;
    boolean firstLeft = true;

    public boolean isValidBST2(TreeNode root) {
        traverse(root);
        return flag;
    }

    void traverse(TreeNode root) {
        if (root == null || !flag) return;
        traverse(root.left);
        if (firstLeft) {
            firstLeft = false;
        } else {
            if (pre >= root.val) {
                flag = false;
                return;
            }
        }
        pre = root.val;
        traverse(root.right);
    }
}
