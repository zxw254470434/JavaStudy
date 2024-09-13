import java.util.*;

public class Didi_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<String> stocks = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            stocks.add(x + " " + y);
        }
        sc.nextLine();
        String[] options = sc.nextLine().split(" ");

        int x = 0, y = 0;
        for (int i = 0; i < 2 * m; i += 2) {
            Character direction = options[i].charAt(0);
            int k = Integer.parseInt(options[i + 1]);
            if (!hasStocks(x, y, direction, k, stocks)) {
                if (direction == 'U') {
                    y += k;
                } else if (direction == 'D') {
                    y -= k;
                } else if (direction == 'L') {
                    x -= k;
                } else if (direction == 'R') {
                    x += k;
                }
            }
        }
        System.out.print(x + " " + y);
    }

    public static boolean hasStocks(int x, int y, Character direction, int k, Set<String> stocks) {
        if (direction == 'U') {
            for (int j = y; j <= y + k; j++) {
                if (stocks.contains(x + " " + j)) {
                    return true;
                }
            }
        } else if (direction == 'D') {
            for (int j = y; j >= y - k; j--) {
                if (stocks.contains(x + " " + j)) {
                    return true;
                }
            }
        } else if (direction == 'R') {
            for (int i = x; i <= x + k; i++) {
                if (stocks.contains(i + " " + y)) {
                    return true;
                }
            }
        } else if (direction == 'L') {
            for (int i = x; i >= x - k; i--) {
                if (stocks.contains(i + " " + y)) {
                    return true;
                }
            }
        }
        return false;
    }
}
