import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution42 {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        int res = 0;
        int left = 0, right = 0;
        //构建一个前缀和数组
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + height[i - 1];
        }
        //从左到右扫描，找到第一个高度大于0，且height[i] > height[i + 1]的柱子
        for (int i = 0; i < n - 1; i++) {
            if (height[i] > height[i + 1]) {
                if (left == n - 2) return 0;
                left = i;
                break;
            }
        }
        //从左到右，检测每个峰值，2个峰值之间必定有雨水
        while (left < n - 1) {
            //若left=n-2，则结束
            if (left == n - 2) break;
            //若height[left] <= height[left + 1]，则右边存在极值点
            if (height[left] <= height[left + 1]) {
                left += 1;
                continue;
            }
            right = left;
            //从左到右尝试找到一个极值点right，满足height[right] >= height[right + 1]
            for (int i = left + 1; i < n; i++) {
                if (height[i - 1] < height[i] && height[i] >= height[i + 1]) {
                    right = i;
                    break;
                }
            }
            if (right == left) {
                left += 1;//若找不到height[right] >= height[left]，则left += 1，进入下一循环
            } else {//若找到，则计算雨水
                int area = Math.min(height[left], height[right]) * (right - left - 1);
                //计算[left+1,right-1]中间的柱子所占用的的面积
                int box = preSum[right] - preSum[left + 1];
                //能接多少雨水int
                int rain = area - box;
                res += rain;

                left = right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        int res = new Solution42().trap(height);
        System.out.println("res = " + res);
    }
}
