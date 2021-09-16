package bj.secondweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ9095 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int n = 4; n <= 11; n++) {
            dp[n] = dp[n-1] + dp[n-2] + dp[n-3];
        }

        int T = Integer.parseInt(br.readLine());

        for (int ti = 0; ti < T; ti++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[n]);
        }
    }
}
