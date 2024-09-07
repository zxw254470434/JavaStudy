import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MeiTuan_Autumn_Test_25_04_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = in.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < positions[n - 1]; i++) {
            for (int j = 0; j < n; j++) {
                int position = positions[j];
                for (int l = 0; l < i; l++) {
                    set.add(position + l);
                }
            }
            if (set.size() >= k) {
                System.out.println(i);
                break;
            }
            set.clear();
        }
    }
}
