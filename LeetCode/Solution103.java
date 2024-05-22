import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //控制遍历方向，1，左到右，-1，右到左
        int dir = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            dir = -dir;
            List<Integer> layer = new ArrayList<>();
            if (dir == 1) { //从左到右遍历
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    layer.add(cur.val);
                    if (cur.left != null) q.offer(cur.left);
                    if (cur.right != null) q.offer(cur.right);
                }
            } else { //从右到左遍历
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    layer.add(0, cur.val);
                    if (cur.left != null) q.offer(cur.left);
                    if (cur.right != null) q.offer(cur.right);
                }
            }
            res.add(layer);
        }
        return res;
    }
}
