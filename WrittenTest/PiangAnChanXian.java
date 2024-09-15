import java.util.HashMap;

public class PiangAnChanXian {
    /**
     * 长为n的数组，找出有多少个子数组之和为k
     * 力扣560原题
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        // write code here
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
