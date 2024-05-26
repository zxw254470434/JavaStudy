import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    List<String> res = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        dfs("", n, n);
        return res;
    }

    public void dfs(String track, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(track);
            return;
        }
        if (left == right) {
            dfs(track + '(', left - 1, right);
        } else if (left < right) {
            if (left > 0) dfs(track + '(', left - 1, right);
            dfs(track + ')', left, right - 1);
        }
    }
}
