import java.util.HashMap;

public class Solution904 {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int fruit : fruits) {
            map.put(fruit, 0);
        }
        int max = 0;
        int cate = 0;
        int left = 0, right = 0;
        while (right < fruits.length) {
            if (map.get(fruits[right]) == 0) {
                cate += 1;
            }
            map.put(fruits[right], map.get(fruits[right]) + 1);
            right++;

            while (cate > 2) {
                if (map.get(fruits[left]) == 1) {
                    cate -= 1;
                }
                map.put(fruits[left], map.get(fruits[left]) - 1);
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
