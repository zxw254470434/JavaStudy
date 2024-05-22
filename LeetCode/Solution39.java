import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    List<List<Integer>> res;
    List<Integer> track;
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        backtrack(candidates, target, 0);
        return res;
    }

    void backtrack(int[] candidates, int target, int start) {
        if (trackSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            trackSum += candidates[i];
            track.add(candidates[i]);
            backtrack(candidates, target, i);
            trackSum -= candidates[i];
            track.remove(track.size()-1);
        }
    }
}

