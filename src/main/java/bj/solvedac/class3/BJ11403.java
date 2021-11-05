package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ11403 {
    private static int N;
    private static boolean[][] path;

    public static void main(String[] args) throws Throwable {
        init();
        floyd();
        solve();
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        N = Integer.parseInt(br.readLine());

        path = new boolean[N][N];

        for (int py = 0; py < N; py++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int px = 0; px < N; px++) {
                path[py][px] = st.nextToken().equals("1");
            }
        }

        br.close();
    }

    private static void floyd() {
        // stop over, 경유점
        for (int so = 0; so < N; so++) {
            for (int from = 0; from < N; from++) {
                for (int to = 0; to < N; to++) {
                    if (path[from][so] && path[so][to]) {
                        path[from][to] = true;
                    }
                }
            }
        }
    }

    private static void solve() throws Throwable {
        final BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out), 1<<10
        );

        for (int py = 0; py < N; py++) {
            for (int px = 0; px < N; px++) {
                bw.write(
                        path[py][px] ? '1' : '0'
                );

                bw.write(' ');
            }
            bw.write('\n');
        }

        bw.flush();
        bw.close();
    }
}
