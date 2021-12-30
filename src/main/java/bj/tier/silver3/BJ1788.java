package bj.tier.silver3;

import java.util.Scanner;

public class BJ1788 {
    private static final int[] fibo = new int[2_000_005];
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Throwable {
        fibo[f(0)] = 0;
        fibo[f(1)] = 1;

        // 양수
        for (int n = 2; n <= 1_000_000; n++) {
            fibo[f(n)] = (fibo[f(n-1)] + fibo[f(n-2)]) % MOD;
        }

        // 음수
        for (int n = 1; n >= -1_000_000; n--) {
            fibo[f(n-2)] = (fibo[f(n)] - fibo[f(n-1)]) % MOD;
        }

        final Scanner sc = new Scanner(System.in);

        final int answer = fibo[f(sc.nextInt())];

        if (answer < 0) {
            System.out.println(-1);
        } else if (answer > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        System.out.println(Math.abs(answer));

        sc.close();
    }

    private static int f(int n) {
        return n + 1_000_002;
    }
}
