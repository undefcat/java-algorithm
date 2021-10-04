package bj.comito.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1463 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1_000_001];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int n = 4; n <= N; n++) {
            dp[n] = dp[n-1];

            if (n%2 == 0) {
                dp[n] = Math.min(dp[n], dp[n/2]);
            }

            if (n%3 == 0) {
                dp[n] = Math.min(dp[n], dp[n/3]);
            }

            // 1회 연산 횟수를 더한다.
            dp[n]++;
        }

        System.out.print(dp[N]);
    }
}
