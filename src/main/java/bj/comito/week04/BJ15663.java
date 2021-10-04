package bj.comito.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15663 {
    private static int N;
    private static int M;
    private static int[] numbers;
    private static int[] picked;
    private static boolean[] used;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final StringBuilder sb = new StringBuilder(1<<16);

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        picked = new int[M];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int n = 0; n < N; n++) {
            numbers[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        pick(0);

        System.out.print(sb);
    }

    private static void pick(int index) {
        if (index == M) {
            appends();
            return;
        }

        int beforeNumber = -1;
        for (int i = 0; i < N; i++) {
            if (used[i]) {
                continue;
            }

            int number = numbers[i];
            if (number == beforeNumber) {
                continue;
            }

            beforeNumber = number;

            used[i] = true;
            picked[index] = number;

            pick(index+1);

            used[i] = false;
        }
    }

    private static void appends() {
        for (int n: picked) {
            sb.append(n);
            sb.append(' ');
        }

        sb.append('\n');
    }
}
