public class Solution538 {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.right);

        sum += root.val;
        root.val = sum;

        traverse(root.left);
    }
}
