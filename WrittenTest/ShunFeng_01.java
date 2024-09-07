import java.util.*;

public class ShunFeng_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] a=new int[n];
            for (int j = 0; j < n; j++) {
                a[j]=sc.nextInt();
            }
            Arrays.sort(a);
            int count=0,sum=0;
            for (int j = 0; j < n; j++) {
                if (count<k){
                    a[j]=-a[j];
                    count++;
                    sum+=a[j];
                }else {
                    sum+=a[j];
                }
            }
            System.out.println(sum);
        }
    }
}
