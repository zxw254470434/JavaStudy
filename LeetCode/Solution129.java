public class Solution129 {
    StringBuilder sb;
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        sb = new StringBuilder();
        traverse(root);
        return sum;
    }

    void traverse(TreeNode root) {
        if (root == null) return;

        sb.append(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(sb.toString());
        }

        traverse(root.left);
        traverse(root.right);

        sb.deleteCharAt(sb.length() - 1);
    }
}
