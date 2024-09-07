import java.util.Scanner;

public class Xiaomi_02 {

    static final int MOD = 998244353;

    static long binomialCoeff(int n, int k, long[] factorial, long[] invFactorial) {
        if (k > n) return 0;
        return factorial[n] * (invFactorial[k] * invFactorial[n - k] % MOD) % MOD;
    }

    static long catalan(int n, long[] factorial, long[] invFactorial) {
        return binomialCoeff(2 * n, n, factorial, invFactorial) * invFactorial[n + 1] % MOD;
    }

    static long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] factorial = new long[2 * n + 1];
        long[] invFactorial = new long[2 * n + 1];
        factorial[0] = 1;
        invFactorial[0] = 1;
        for (int i = 1; i <= 2 * n; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
            invFactorial[i] = modPow(factorial[i], MOD - 2);
        }

        long catalanNumber = catalan(n / 2, factorial, invFactorial);
        long kPowerN = modPow(k, n / 2);
        long result = catalanNumber * kPowerN % MOD;

        System.out.println(result);
    }
}
