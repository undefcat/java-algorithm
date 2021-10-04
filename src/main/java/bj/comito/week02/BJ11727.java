package bj.comito.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11727 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final int MAX_VALUE = 1_001;
    private static final int MOD = 10_007;

    public static void main(String[] args) throws Throwable {
        int[] dp = new int[MAX_VALUE];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;

        for (int n = 3; n < MAX_VALUE; n++) {
            dp[n] = dp[n-1] + (2*dp[n-2]);
            dp[n] %= MOD;
        }

        int n = Integer.parseInt(br.readLine());

        System.out.println(dp[n]);
    }
}
