import java.util.*;

public class LianTong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数组的大小
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // 输入数组的元素
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        double result = averageAfterRemovingMinMax(nums);
        System.out.printf("%.2f\n", result);
    }

    // 调用（补全）方法计算去掉最大值、最小值后的数组元素的平均值
    public static double averageAfterRemovingMinMax(int[] nums) {
        Arrays.sort(nums);
        double result = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            result += nums[i];
        }
        result = result / (nums.length - 2);
        return result;
    }
}
