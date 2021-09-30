package bj.thirdweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11052 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int[] packs = new int[N+1];
        final int[] dp = new int[N+1];

        for (int ni = 1; ni <= N; ni++) {
            packs[ni] = Integer.parseInt(st.nextToken());
            dp[ni] = packs[ni];

            for (int pi = 1; pi < ni; pi++) {
                dp[ni] = Math.max(dp[ni], dp[ni-pi] + packs[pi]);
            }
        }

        System.out.println(dp[N]);
    }
}
