package bj.secondweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ15988 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final StringBuffer sb = new StringBuffer(100_000);

    private static final int MAX_VALUE = 1_000_001;
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws Throwable {
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[MAX_VALUE];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int n = 4; n < MAX_VALUE; n++) {
            for (int i = 1; i <= 3; i++) {
                dp[n] += dp[n-i];
                dp[n] %= MOD;
            }
        }

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n]);
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
