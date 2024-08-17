import java.util.HashMap;
import java.util.Map;

public class Solution570 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }

        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>(n + 1); // 设置容量可以快 2ms
        for (int sj : s) {
            ans += cnt.getOrDefault(sj - k, 0);
            cnt.merge(sj, 1, Integer::sum);
        }
        return ans;
    }
}
