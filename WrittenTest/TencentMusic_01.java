import java.util.*;

public class TencentMusic_01 {
    public ArrayList<Integer> newArray(ArrayList<Integer> a) {
        // write code here
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer num : a) {
            StringBuilder sb = new StringBuilder();
            for (char c : num.toString().toCharArray()) {
                if (c != '2') {
                    sb.append(c);
                }
            }
            if (sb.length() == 0) {
                continue;
            }
            int num2 = Integer.parseInt(sb.toString());
            result.add(num2);
        }
        return result;
    }
}
