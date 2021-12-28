package bj.tier.silver3;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ2407 {
    private static final BigInteger[][] cache = new BigInteger[101][101];

    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int r = sc.nextInt();

        sc.close();

        System.out.println(combination(n, r).toString());
    }

    private static BigInteger combination(int n, int r) {
        if (cache[n][r] != null) {
            return cache[n][r];
        }

        if (n == r || r == 0) {
            cache[n][r] = BigInteger.ONE;

            return cache[n][r];
        }

        cache[n][r] = combination(n-1, r-1).add(combination(n-1, r));

        return cache[n][r];
    }
}
