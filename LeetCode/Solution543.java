/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * 【每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和】
 */
public class Solution543 {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int myDiameter = left + right;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        return 1 + Math.max(left, right);
    }
}
