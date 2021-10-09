package bj.comito.week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ10844 {
    private static final int MOD = 1_000_000_000;
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        final int N = Integer.parseInt(br.readLine());

        final int[][] dp = new int[101][10];

        for (int n = 1; n <= 9; n++) {
            dp[1][n] = 1;
        }

        // n자리의 수
        for (int n = 2; n <= 100; n++) {
            // 끝수
            for (int tail = 0; tail <= 9; tail++) {
                int up = tail+1;
                int down = tail-1;

                if (up < 10) {
                    dp[n][tail] += dp[n-1][up];
                }

                if (down >= 0) {
                    dp[n][tail] += dp[n-1][down];
                }

                dp[n][tail] %= MOD;
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
            sum %= MOD;
        }

        System.out.println(sum);
    }
}
