package bj.comito.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11726 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        // new int[N+1]로 초기화 하는 경우,
        // N이 1이면 dp[2]가 ArrayIndexOutOfBounds 예외를 던지게 된다.
        // 그냥 입력 n의 최댓값을 이용해 초기화 하자.
        int[] dp = new int[1_001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int n = 3; n <= N; n++) {
            dp[n] = dp[n-2] + dp[n-1];
            dp[n] %= 10_007;
        }

        System.out.println(dp[N]);
    }
}
