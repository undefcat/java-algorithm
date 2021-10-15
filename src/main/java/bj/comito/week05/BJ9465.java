package bj.comito.week05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ9465 {
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int NONE = 2;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out)
    );

    public static void main(String[] args) throws Throwable {
        final int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            bw.write(Integer.toString(solve()));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int solve() throws Throwable {
        final int N = Integer.parseInt(br.readLine());

        final int[][] dp = new int[N][3];
        final int[][] stickers = new int[N][2];

        StringTokenizer row1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer row2 = new StringTokenizer(br.readLine(), " ");

        for (int n = 0; n < N; n++) {
            stickers[n][0] = Integer.parseInt(row1.nextToken());
            stickers[n][1] = Integer.parseInt(row2.nextToken());
        }

        dp[0][UP] = stickers[0][UP];
        dp[0][DOWN] = stickers[0][DOWN];
        dp[0][NONE] = 0;

        for (int n = 1; n < N; n++) {
            dp[n][UP] = stickers[n][UP] + Math.max(dp[n-1][DOWN], dp[n-1][NONE]);
            dp[n][DOWN] = stickers[n][DOWN] + Math.max(dp[n-1][UP], dp[n-1][NONE]);
            dp[n][NONE] = Math.max(dp[n-1][UP], dp[n-1][DOWN]);
        }

        return Math.max(dp[N-1][UP], dp[N-1][DOWN]);
    }
}
