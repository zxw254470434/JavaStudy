import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        } else if (n == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }

        int left = 0, right = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                right++;
                if (i == n - 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(nums[left]));
                    if (right != left) {
                        sb.append('-');
                        sb.append('>');
                        sb.append(String.valueOf(nums[right]));
                        res.add(sb.toString());
                    } else {
                        res.add(sb.toString());
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(nums[left]));
                if (right != left) {
                    sb.append('-');
                    sb.append('>');
                    sb.append(String.valueOf(nums[right]));
                    res.add(sb.toString());
                } else {
                    res.add(sb.toString());
                }

                right++;
                left = right;
                if (right == n - 1) {
                    res.add(String.valueOf(nums[right]));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        List<String> res = new Solution228().summaryRanges(nums);
        System.out.println("res = " + res);
    }
}
