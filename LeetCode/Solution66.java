import java.util.ArrayList;
import java.util.List;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        int local = 0;
        int carry = 1;
        List<Integer> res = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            local = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            res.add(0, local);
        }
        if (carry != 0) res.add(0,carry);

        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
