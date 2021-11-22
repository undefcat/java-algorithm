package bj.tier.silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11497 {
    public static void main(String[] args) throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out), 1<<5
        );

        final int T = Integer.parseInt(br.readLine());

        final int[] heights = new int[10_001];

        for (int t = 0; t < T; t++) {
            final int N = Integer.parseInt(br.readLine());

            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int n = 0; n < N; n++) {
                heights[n] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(heights, 0, N);

            int ans = 0;
            final int endN = N-2;
            for (int n = 0; n < endN; n++) {
                ans = Math.max(ans, Math.abs(heights[n] - heights[n+2]));
            }

            ans = Math.max(ans, heights[1] - heights[0]);
            ans = Math.max(ans, heights[N-1] - heights[N-2]);

            bw.write(Integer.toString(ans));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
