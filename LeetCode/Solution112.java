public class Solution112 {
    int target = 0;
    int temp = 0;
    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        traverse(root);
        return flag;
    }

    void traverse(TreeNode root) {
        if (root == null) return;

        temp += root.val;
        if (root.left == null && root.right == null) {
            if (temp == target) {
                flag = true;
            }
        }
        traverse(root.left);
        traverse(root.right);
        temp -= root.val;
    }
}
