public class Solution367 {
    public boolean isPerfectSquare(int num) {
        /**
         * 4=1+3
         * 9=1+3+5
         * 16=1+3+5+7
         * 25=1+3+5+7+9
         * ...
         * 使num不断减去一个从1开始不断增大的奇数，若最终减成了0，说明是完全平方数，否则，不是。
         */
        int num1 = 1;
        while (num > 0) {
            num -= num1;
            num1 += 2;
        }
        return num == 0;
    }
}
