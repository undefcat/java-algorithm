package bj.firstweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11726 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int n = 3; n <= N; n++) {
            dp[n] = dp[n-2] + dp[n-1];
            dp[n] %= 10_007;
        }

        System.out.println(dp[N]);
    }
}
