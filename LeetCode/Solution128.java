import java.util.Arrays;
import java.util.HashSet;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int len = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current_num = num;
                int current_len = 1;
                while (set.contains(current_num + 1)) {
                    current_num++;
                    current_len++;
                }
                len = Math.max(len, current_len);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 2};
        int longest = new Solution128().longestConsecutive(nums);
        System.out.println("longest = " + longest);
    }
}
