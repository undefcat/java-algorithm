package bj.comito.week05;

import java.util.Arrays;
import java.util.Scanner;

public class BJ11057 {
    private static final int MOD = 10_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        final int[][] dp = new int[1001][10];

        Arrays.fill(dp[1], 1);

        for (int l = 2; l <= 1000; l++) {
            for (int tail = 0; tail <= 9; tail++) {
                for (int up = tail; up <= 9; up++) {
                    dp[l][tail] += dp[l-1][up];
                }

                dp[l][tail] %= MOD;
            }
        }

        int ans = 0;
        for (int tail = 0; tail <= 9; tail++) {
            ans += dp[N][tail];
        }

        System.out.println(ans%MOD);
    }
}
