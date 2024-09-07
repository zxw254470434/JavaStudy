import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  一个N*N的矿场，么个位置有矿藏数量。炸弹可以炸开 上下左右中 个位置。问最多能拿到多少矿藏。
 */
public class LianXiang_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x = in.nextInt();
                if (x != 0) {
                    String i_j = i + " " + j;
                    map.put(i_j, x);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = map.getOrDefault(i + " " + j, 0);
                sum += map.getOrDefault((i + 1) + " " + j, 0);
                sum += map.getOrDefault((i - 1) + " " + j, 0);
                sum += map.getOrDefault(i + " " + (j + 1), 0);
                sum += map.getOrDefault(i + " " + (j - 1), 0);
                res = Math.max(res, sum);
            }
        }
        System.out.println(res);
    }
}
