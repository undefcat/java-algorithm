package bj.tier.silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1946 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<10
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<10
    );

    private static final int[] scores = new int[100_001];

    public static void main(String[] args) throws Throwable {
        final int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            System.out.println(solve());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int solve() throws Throwable {
        final int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());

            scores[a-1] = b-1;
        }

        int pick = 1;
        int prevScore = scores[0];

        for (int n = 1; n < N; n++) {
            if (prevScore < scores[n]) {
                continue;
            }

            prevScore = scores[n];
            pick++;
        }

        return pick;
    }
}
