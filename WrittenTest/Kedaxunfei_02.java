import java.util.*;

public class Kedaxunfei_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(i);
        }

        Set<Integer>[] seenPositions = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) {
            seenPositions[i] = new HashSet<>();
            seenPositions[i].add(i);
        }

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            List<Integer> movedNumbers = list.subList(l, r);
            for (int j = l; j <= r; j++) {
                list.remove(j);
            }
            list.addAll(movedNumbers);

            for (int j = 0; j <=n; j++) {
                seenPositions[list.get(j)].add(j);
            }

        }
        for (int i = 1; i <= n; i++) {
            System.out.print(seenPositions[i].size() + " ");
        }
    }
}
