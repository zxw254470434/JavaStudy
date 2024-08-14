import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(triangle.get(0)));
        int m = triangle.size();
        for (int i = 1; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            int n = triangle.get(i).size();
            for (int j = 0; j < n; j++) {
                int path = 0;
                if (j == 0) {
                    path = result.get(i - 1).get(j) + triangle.get(i).get(j);
                } else if (j == n - 1) {
                    path = result.get(i - 1).get(j - 1) + triangle.get(i).get(j);
                } else {
                    path = Math.min(result.get(i - 1).get(j - 1), result.get(i - 1).get(j)) + triangle.get(i).get(j);
                }
                row.add(path);
            }
            result.add(row);
        }

        int res = result.get(m-1).get(0);
        for (int j = 0; j < result.get(m - 1).size(); j++) {
            res = Math.min(res, result.get(m - 1).get(j));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution120 solution = new Solution120();
        List<List<Integer>> triangle=new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(solution.minimumTotal(triangle));
    }
}
