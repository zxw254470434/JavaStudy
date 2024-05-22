import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> track = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        used = new boolean[n];
        backtrack(nums);
        return res;
    }

    void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            track.add(nums[i]);

            backtrack(nums);

            track.remove(track.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> res=new Solution46().permute(nums);
        System.out.println("res = " + res);;
    }
}
