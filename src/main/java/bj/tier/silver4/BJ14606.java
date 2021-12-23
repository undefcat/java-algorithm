package bj.tier.silver4;

import java.util.Scanner;

public class BJ14606 {
    public static void main(String[] args) {
        final int[] dp = new int[11];

        dp[1] = 0;
        dp[2] = 1;

        for (int n = 3; n <= 10; n++) {
            final int mid = n / 2;

            for (int m = 1; m <= mid; m++) {
                final int a = m;
                final int b = n - m;

                final int candi = a * b + dp[a] + dp[b];

                dp[n] = Math.max(dp[n], candi);
            }
        }

        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        sc.close();

        System.out.println(dp[N]);
    }
}
