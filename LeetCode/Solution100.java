public class Solution100 {
    //遍历
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

    //递归
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        if (!isSameTree2(p.left, q.left)) return false;
        if (!isSameTree2(p.right, q.right)) return false;

        return true;
    }
}
