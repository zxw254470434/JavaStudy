public class Solution172 {
    public int trailingZeroes(int n) {
        int count = 0;
        int iter = 5;
        while (n >= iter) {
            count += n / iter;
            iter *= 5;
        }
        return count;
    }
}
