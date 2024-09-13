import java.util.*;

public class Haoweilai_01 {
    /**
     * 给定长为n的数组，每个数字不同，找出0-n中未出现的第一个整数
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int missing_number(int[] nums) {
        // write code here
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
