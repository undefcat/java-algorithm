package bj.comito.codeplus.basic.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11722 {
    private static int N;
    private static int[] sequence;
    private static int[] length;

    public static void main(String[] args) throws Throwable {
        init();

        System.out.println(dp());
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        N = Integer.parseInt(br.readLine());

        sequence = new int[N];
        length = new int[N];

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int ni = 0; ni < N; ni++) {
            sequence[ni] = Integer.parseInt(st.nextToken());
        }
    }

    private static int dp() {
        int ans = 1;

        // l, r: left, right
        for (int l = N-1; l >= 0; l--) {
            int candi = 1;
            for (int r = l; r < N; r++) {
                if (sequence[r] < sequence[l]) {
                    candi = Math.max(candi, length[r] + 1);
                }
            }

            length[l] = candi;
            ans = Math.max(ans, length[l]);
        }

        return ans;
    }
}
