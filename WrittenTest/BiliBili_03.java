import java.util.ArrayList;
import java.util.List;

public class BiliBili_03 {
    public int[] F(String x) {
        // write code here
        int n = x.length();
        if (n < 3) return new int[0];
        List<Integer> res = new ArrayList<>();
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (flag) {
                break;
            }
            for (int j = i + 1; j < n; j++) {
                String first = x.substring(0, i);
                String second = x.substring(i, j);
                if (!isValid(first) || !isValid(second)) {
                    continue;
                }
                res.clear();
                res.add(Integer.parseInt(first));
                res.add(Integer.parseInt(second));
                while (res.size() < n) {
                    int firstNum = res.get(res.size() - 2);
                    int secondNum = res.get(res.size() - 1);
                    int nextNum = firstNum + secondNum;
                    res.add(nextNum);

                    StringBuilder sb = new StringBuilder();
                    for (int num : res) {
                        sb.append(num);
                    }
                    if (sb.toString().equals(x)) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public boolean isValid(String num) {
        return !(num.length() > 1 && num.charAt(0) == '0');
    }

    public static void main(String[] args) {
        BiliBili_03 bili = new BiliBili_03();
        int[] res = bili.F("12345");
        for (int i : res) {
            System.out.println(i);
        }
    }
}
