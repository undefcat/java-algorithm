package bj.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static int K;
    private static int N;

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        long[] lans = new long[K];
        long total = 0;
        for (int k = 0; k < K; k++) {
            lans[k] = Long.parseLong(br.readLine());
            total += lans[k];
        }

        long answer = 1;
        long left = 1;
        long right = total / N;

        // 이 부분의 조건이 left < right 이면 안 된다..!
        // 정답이 left, right과 같은 곳에 있을 수도 있기 때문!
        while (left <= right) {
            long sum = 0;
            long length = (left + right) / 2;

            for (long lan: lans) {
                sum += lan / length;
            }

            if (sum >= N) {
                // 답이 될 수 있는 최대 후보
                answer = Math.max(answer, length);
                left = length + 1;

            } else {
                right = length - 1;
            }
        }

        System.out.println(answer);
    }
}
