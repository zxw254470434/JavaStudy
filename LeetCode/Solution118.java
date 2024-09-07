import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> c = new ArrayList<>(numRows); // 预分配空间
        c.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1); // 预分配空间
            row.add(1);
            for (int j = 1; j < i; j++) {
                // 左上方的数 + 正上方的数
                row.add(c.get(i - 1).get(j - 1) + c.get(i - 1).get(j));
            }
            row.add(1);
            c.add(row);
        }
        return c;
    }
}
