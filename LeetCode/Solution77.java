import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution77 {
    List<List<Integer>> res;
    List<Integer> track;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        backtrack(1, n, k);
        return res;
    }

    void backtrack(int start, int n, int k) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(i + 1, n, k);
            track.remove(track.size() - 1);
        }
    }
}
