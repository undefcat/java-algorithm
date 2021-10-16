package bj.comito.codeplus.basic.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ6603 {
    private static final int MAX_LOTTO = 6;

    private static int K;
    private static int endIndex;

    private static final int[] numbers = new int[12];
    private static final int[] picked = new int[MAX_LOTTO];

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final StringBuilder sb = new StringBuilder(1<<16);

    public static void main(String[] args) throws Throwable {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                break;
            }

            for (int k = 0; k < K; k++) {
                numbers[k] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers, 0, K);

            endIndex = K - MAX_LOTTO + 1;

            lotto(0, 0);

            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static void lotto(int lottoIndex, int start) {
        if (lottoIndex == MAX_LOTTO) {
            appends();
            return;
        }

        for (int i = start; i < K; i++) {
            // 앞으로 6개를 더 뽑을 수 있지 않다면 끝낸다.
            if (lottoIndex == 0 && i == endIndex) {
                break;
            }

            picked[lottoIndex] = numbers[i];
            lotto(lottoIndex+1, i+1);
        }
    }

    private static void appends() {
        for (int i = 0; i < MAX_LOTTO; i++) {
            sb.append(picked[i]);
            sb.append(' ');
        }

        sb.append('\n');
    }
}
