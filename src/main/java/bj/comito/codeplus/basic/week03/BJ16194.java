package bj.comito.codeplus.basic.week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16194 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int[] packs = new int[N+1];
        final int[] dp = new int[N+1];

        for (int ni = 1; ni <= N; ni++) {
            packs[ni] = Integer.parseInt(st.nextToken());
            dp[ni] = packs[ni];

            for (int di = 1; di < ni; di++) {
                dp[ni] = Math.min(dp[ni], dp[ni-di] + packs[di]);
            }
        }

        System.out.println(dp[N]);
    }
}
