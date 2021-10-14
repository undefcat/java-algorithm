package bj.comito.week05;

import java.util.Scanner;

public class BJ2193 {
    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        final long[][] dp = new long[N+1][2];

        dp[1][1] = 1;

        for (int n = 2; n <= N; n++) {
            dp[n][0] = dp[n-1][0] + dp[n-1][1];
            dp[n][1] = dp[n-1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);

        sc.close();
    }
}
