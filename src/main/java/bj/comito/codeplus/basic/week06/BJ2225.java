package bj.comito.codeplus.basic.week06;

import java.util.Scanner;

public class BJ2225 {
    private static final int MOD = 1_000_000_000;
    private static int N;
    private static int K;

    public static void main(String[] args) throws Throwable {
        init();

        System.out.println(dp());
    }

    private static void init() throws Throwable {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        sc.close();
    }

    private static int dp() {
        final int[][] cache = new int[K+1][N+1];

        for (int n = 0; n <= N; n++) {
            cache[1][n] = 1;
        }

        for (int k = 2; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                for (int sum = 0; sum <= N; sum++) {
                    final int result = sum - n;
                    if (result < 0) {
                        continue;
                    }
                    cache[k][sum] += cache[k-1][sum-n];
                    cache[k][sum] %= MOD;
                }
            }
        }

        return cache[K][N];
    }
}
