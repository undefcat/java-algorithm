package bj.comito.codeplus.basic.week06;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1699 {
    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final int[] dp = new int[N+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 1;

        final int last = (int)Math.sqrt(N);

        // 우선 제곱수가 하나인 자연수는
        // 1로 초기화한다.
        for (int n = 2; n <= last; n++) {
            dp[n*n] = 1;
        }

        // 어떤 자연수의 제곱수 합의 최소 갯수는
        // 1이다.
        // 이는 자신이 어떤 자연수의 제곱수인 경우다.
        // 따라서, 자신의 2제곱근수부터 시작해서
        // 1씩 감소되는 수의 최소항의 갯수를 따져보면 된다.
        for (int n = 2; n <= N; n++) {
            if (dp[n] == 1) {
                continue;
            }

            final int sqrtN = (int)Math.sqrt(n);

            for (int m = sqrtN; m >= 1; m--) {
                final int squareM = m*m;

                dp[n] = Math.min(dp[n], dp[squareM] + dp[n - squareM]);
            }
        }

        System.out.println(dp[N]);
    }
}
