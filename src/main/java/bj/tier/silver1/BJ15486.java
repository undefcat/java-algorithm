package bj.tier.silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15486 {
    private static final int MAX = 1_500_001;
    private static final int[] T = new int[MAX];
    private static final int[] P = new int[MAX];

    public static void main(String[] args) throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final int N = Integer.parseInt(br.readLine());

        for (int day = 1; day <= N; day++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            T[day] = Integer.parseInt(st.nextToken());
            P[day] = Integer.parseInt(st.nextToken());
        }

        final int[] dp = new int[MAX + 50];
        for (int day = 1; day <= N; day++) {
            final int afterDay = day + T[day];
            final int tomorrow = day + 1;

            dp[afterDay] = Math.max(dp[afterDay], dp[day] + P[day]);
            dp[tomorrow] = Math.max(dp[tomorrow], dp[day]);
        }

        System.out.println(dp[N+1]);
    }
}
