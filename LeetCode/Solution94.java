import java.util.ArrayList;
import java.util.List;

public class Solution94 {
    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }
}
