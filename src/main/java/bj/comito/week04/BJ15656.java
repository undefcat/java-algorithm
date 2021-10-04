package bj.comito.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15656 {
    private static int N;
    private static int M;

    private static int[] numbers;
    private static int[] picked;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final StringBuilder sb = new StringBuilder(1<<16);

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        numbers = new int[N];
        picked = new int[M];

        for (int ni = 0; ni < N; ni++) {
            numbers[ni] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        pick(0);

        System.out.print(sb);
    }

    private static void pick(int m) {
        if (m == M) {
            for (int number: picked) {
                sb.append(number);
                sb.append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            picked[m] = numbers[i];

            pick(m+1);
        }
    }
}
