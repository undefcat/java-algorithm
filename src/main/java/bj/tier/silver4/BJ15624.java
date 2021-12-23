package bj.tier.silver4;

import java.util.Scanner;

public class BJ15624 {
    private static final int MAX = 1_000_000;
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Throwable {
        final int[] fibo = new int[MAX + 1];

        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;

        for (int n = 3; n <= MAX; n++) {
            fibo[n] = fibo[n-1] + fibo[n-2];
            fibo[n] %= MOD;
        }

        final Scanner sc = new Scanner(System.in);

        System.out.println(fibo[sc.nextInt()]);

        sc.close();
    }
}
