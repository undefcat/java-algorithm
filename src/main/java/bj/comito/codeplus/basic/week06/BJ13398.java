package bj.comito.codeplus.basic.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13398 {
    private static int N;
    private static int[] sequence;

    public static void main(String[] args) throws Throwable {
        init();

        System.out.println(dp());
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        N = Integer.parseInt(br.readLine());

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        sequence = new int[N];
        for (int ni = 0; ni < N; ni++) {
            sequence[ni] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    private static int dp() {
        if (N == 1) {
            return sequence[0];
        }

        int ans = sequence[0];

        // cache[n]은 n까지의 수열 중 최대 연속합
        // cache[n][0]은 수를 빼지 않은 경우의 최대 연속합
        // cache[n][1]은 수를 하나 뺀 경우의 최대 연속합
        final int[][] cache = new int[N][2];
        cache[0][0] = sequence[0];

        for (int ni = 1; ni < N; ni++) {
            // 수를 빼지 않는 경우는
            // 기존 연속합처럼 구한다.
            cache[ni][0] = Math.max(cache[ni-1][0] + sequence[ni], sequence[ni]);

            // 수를 빼는 경우는
            // 1. 얘를 처음 빼는 경우
            // 2. 이전에 뺀 경우
            cache[ni][1] = Math.max(cache[ni-1][0], cache[ni-1][1] + sequence[ni]);

            ans = Math.max(
                    ans,
                    Math.max(cache[ni][0], cache[ni][1])
            );
        }

        return ans;
    }
}
