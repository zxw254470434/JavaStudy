public class Solution101 {
    //先将root的右子树左右翻转，若与root的左子树相同，则轴对称
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        root.right = invertTree(root.right);

        return isSameTree(root.left, root.right);
    }

    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    //遍历检查两棵树是否相同
    boolean flag = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        traverse(p, q);
        return flag;
    }

    void traverse(TreeNode p, TreeNode q) {
        if (p == null && q == null) return;
        if (p == null && q != null || p != null && q == null) {
            flag = false;
            return;
        }
        if (p.val != q.val) {
            flag = false;
            return;
        }

        traverse(p.left, q.left);
        traverse(p.right, q.right);
    }
}
