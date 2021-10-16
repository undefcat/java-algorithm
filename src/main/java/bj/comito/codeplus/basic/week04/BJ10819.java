package bj.comito.codeplus.basic.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10819 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static int N;

    private static int max = Integer.MIN_VALUE;

    private static int[] numbers;
    private static int[] picked;
    private static boolean[] used;

    public static void main(String[] args) throws Throwable {
        N = Integer.parseInt(br.readLine());

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        numbers = new int[N];
        used = new boolean[N];
        picked = new int[N];

        for (int ni = 0; ni < N; ni++) {
            numbers[ni] = Integer.parseInt(st.nextToken());
        }

        pick(0);
        System.out.println(max);
    }

    private static void pick(int index) {
        if (index == N) {
            int sum = 0;

            for (int i = 0; i < N-1; i++) {
                sum += Math.abs(picked[i] - picked[i+1]);
            }

            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            picked[index] = numbers[i];

            pick(index+1);

            used[i] = false;
        }
    }
}
