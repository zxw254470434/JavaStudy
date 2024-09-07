import java.util.*;

public class JingDong_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int start=1,end=n;

        for (int i = 0; i < m; i++) {
            int l=sc.nextInt();
            int r=sc.nextInt();
            start=Math.max(start,l);
            end=Math.min(end,r);
        }
        int count=Math.max(0,end-start+1);

        System.out.println(count);
    }
}
