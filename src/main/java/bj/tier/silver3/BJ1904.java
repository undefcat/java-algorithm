package bj.tier.silver3;

import java.util.Scanner;

public class BJ1904 {
    public static void main(String[] args) throws Throwable {
        final int dp[] = new int[1_000_001];

        dp[1] = 1;
        dp[2] = 2;
        for (int n = 3; n <= 1_000_000; n++) {
            dp[n] = dp[n-1] + dp[n-2];
            dp[n] %= 15_746;
        }

        final Scanner sc = new Scanner(System.in);

        System.out.println(dp[sc.nextInt()]);

        sc.close();
    }
}
