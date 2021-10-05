package bj.comito.week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1697 {
    private final static int MAX_RANGE = 100_001;
    private final static int MAX_VALUE = 123_456_789;
    private final static int[] dp = new int[MAX_RANGE];

    private static int N;
    private static int K;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<10
    );

    public static void main(String[] args) throws Throwable {
        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N > K) {
            int tmp = N;
            N = K;
            K = tmp;
        }

        Arrays.fill(dp, MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            dp[i] = N - i;
        }

        for (int i = N+1; i <= K; i++) {
            dp[i] = Math.min(dp[i], dp[i-1] + 1);

            if (i%2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
        }

        System.out.println(dp[K]);
    }
}
