import java.util.ArrayList;
import java.util.List;

public class Solution173 {
    TreeNode root;
    ArrayList<Integer> values = new ArrayList<>();
    int index = 0;

    public Solution173(TreeNode root) {
        root = root;
        inOrderTraverse(root);
    }

    public int next() {
        return values.get(index++);
    }

    public boolean hasNext() {
        return index < values.size() ? true : false;
    }

    void inOrderTraverse(TreeNode root) {
        if (root == null) return;

        inOrderTraverse(root.left);
        values.add(root.val);
        inOrderTraverse(root.right);
    }
}
