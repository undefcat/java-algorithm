package bj.comito.codeplus.basic.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11053 {
    private static int N;
    private static int[] sequence;

    public static void main(String[] args) throws Throwable {
        input();

        System.out.println(dp());
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<15
        );

        N = Integer.parseInt(br.readLine());
        sequence = new int[N];

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int ni = 0; ni < N; ni++) {
            sequence[ni] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    private static int dp() {
        int ans = Integer.MIN_VALUE;

        final int[] length = new int[N];

        for (int si = N-1; si >= 0; si--) {
            int candi = 1;

            for (int sj = si; sj < N; sj++) {
                if (sequence[sj] > sequence[si]) {
                    candi = Math.max(candi, length[sj] + 1);
                }
            }

            length[si] = candi;
            ans = Math.max(ans, length[si]);
        }

        return ans;
    }
}
