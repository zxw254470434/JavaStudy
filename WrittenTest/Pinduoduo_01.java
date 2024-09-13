import java.util.*;

public class Pinduoduo_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String s = in.nextLine();

        int maxLength = find(s);
        System.out.println(maxLength);
    }

    public static int find(String s) {
        Map<Integer, Integer> predixSumMap = new HashMap<>();
        predixSumMap.put(0, -1);

        int maxLength = 0;
        int prefixSum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                prefixSum++;
            } else if (c == 'B') {
                prefixSum--;
            }

            if (predixSumMap.containsKey(prefixSum)) {
                int prevIndex = predixSumMap.get(prefixSum);
                int length = i - prevIndex;
                maxLength = Math.max(maxLength, length);
            } else {
                predixSumMap.put(prefixSum, i);
            }
        }
        return maxLength;
    }
}
