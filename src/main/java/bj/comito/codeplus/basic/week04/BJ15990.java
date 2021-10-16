package bj.comito.codeplus.basic.week04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ15990 {
    private static final long MOD = 1_000_000_009;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<16
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        final int T = Integer.parseInt(br.readLine());
        final long[][] dp = new long[100_001][3];

        dp[1][0] = 1;

        dp[2][1] = 1;

        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        for (int n = 4; n <= 100_000; n++) {
            dp[n][0] = (dp[n-1][1] + dp[n-1][2]) % MOD;
            dp[n][1] = (dp[n-2][0] + dp[n-2][2]) % MOD;
            dp[n][2] = (dp[n-3][0] + dp[n-3][1]) % MOD;
        }

        for (int t = 0; t < T; t++) {
            final int N = Integer.parseInt(br.readLine());

            long sum = dp[N][0] + dp[N][1] + dp[N][2];

            bw.write(Long.toString(sum%MOD));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
