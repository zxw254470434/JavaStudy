import java.util.*;

public class ShunFeng_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[7];
        for (int i = 1; i <= 6; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int count_all = 0;
        for (int i1 = 0; i1 <= 3; i1++) {
            for (int i2 = 0; i2 <= 3; i2++) {
                for (int i3 = 0; i3 <= 3; i3++) {
                    for (int i4 = 0; i4 <= 3; i4++) {
                        for (int i5 = 0; i5 <= 3; i5++) {
                            for (int i6 = 0; i6 <= 3; i6++) {
                                for (int i7 = 0; i7 <= 3; i7++) {
                                    for (int i8 = 0; i8 <= 3; i8++) {
                                        for (int i9 = 0; i9 <= 3; i9++) {
                                            int count = 0;
                                            if (a[1] == (i1 ^ i2 ^ i3)) count++;
                                            if (a[2] == (i4 ^ i5 ^ i6)) count++;
                                            if (a[3] == (i7 ^ i8 ^ i9)) count++;
                                            if (a[4] == (i1 ^ i4 ^ i7)) count++;
                                            if (a[5] == (i2 ^ i5 ^ i8)) count++;
                                            if (a[6] == (i3 ^ i6 ^ i9)) count++;
                                            if (count >= k) count_all++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count_all);
    }
}
