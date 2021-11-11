package bj.tier.silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2565 {
    private static final int[] lines = new int[501];
    private static final int[] length = new int[501];

    private static int N;
    private static int maxPosition = Integer.MIN_VALUE;

    public static void main(String[] args) throws Throwable {
        init();

        System.out.println(solve());
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        N = Integer.parseInt(br.readLine());

        for (int ni = 0; ni < N; ni++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());

            lines[a] = b;
            maxPosition = Math.max(maxPosition, a);
        }

        br.close();
    }

    private static int solve() {
        int ans = 0;

        for (int l = maxPosition; l >= 0; l--) {
            if (lines[l] == 0) {
                continue;
            }

            length[l] = 1;

            for (int r = l; r <= maxPosition; r++) {
                if (lines[r] == 0) {
                    continue;
                }

                if (lines[r] > lines[l]) {
                    length[l] = Math.max(length[l], length[r] + 1);
                }
            }

            ans = Math.max(ans, length[l]);
        }

        return N - ans;
    }
}
