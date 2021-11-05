package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ11659 {
    private static int[] sums;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<10
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<10
    );

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        sums = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        sums[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int mi = 0; mi < M; mi++) {
            st = new StringTokenizer(br.readLine(), " ");

            final int from = Integer.parseInt(st.nextToken()) - 1;
            final int to = Integer.parseInt(st.nextToken()) - 1;

            final int ans = from == 0
                    ? sums[to]
                    : sums[to] - sums[from-1];

            bw.write(Integer.toString(ans));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
