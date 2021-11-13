package bj.tier.silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1932 {
    private static int N;
    private static int[][] triangle;

    public static void main(String[] args) throws Throwable {
        init();

        System.out.println(solveDp());
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        N = Integer.parseInt(br.readLine());

        triangle = new int[N][N];

        for (int y = 0; y < N; y++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int x = 0; x <= y; x++) {
                triangle[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }

    private static int solveDp() {
        final int[] deltaX = {-1, 0};

        for (int y = 1; y < N; y++) {
            for (int x = 0; x < N; x++){
                int candi = 0;
                for (int dx: deltaX) {
                    final int xx = x + dx;

                    if (xx < 0) {
                        continue;
                    }

                    candi = Math.max(candi, triangle[y-1][xx]);
                }

                triangle[y][x] += candi;
            }
        }

        int ans = 0;
        for (int candi: triangle[N-1]) {
            ans = Math.max(ans, candi);
        }

        return ans;
    }
}
