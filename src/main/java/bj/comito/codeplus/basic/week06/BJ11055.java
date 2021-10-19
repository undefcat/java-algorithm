package bj.comito.codeplus.basic.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11055 {
    private static int N;
    private static int[] sequence;

    public static void main(String[] args) throws Throwable {
        input();

        System.out.println(dp());
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        N = Integer.parseInt(br.readLine());
        sequence = new int[N];

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int ni = 0; ni < N; ni++) {
            sequence[ni] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    private static int dp() {
        final int[] sum = new int[N];
        int answer = Integer.MIN_VALUE;

        for (int left = N-1; left >= 0; left--) {
            int maxCandi = sequence[left];

            sum[left] = sequence[left];

            for (int right = left; right < N; right++) {
                if (sequence[right] > sequence[left]) {
                    final int candi = sum[right] + sequence[left];
                    if (candi > maxCandi) {
                        sum[left] = sum[right] + sequence[left];
                        maxCandi = candi;
                    }
                }
            }

            answer = Math.max(answer, maxCandi);
        }

        return answer;
    }
}
