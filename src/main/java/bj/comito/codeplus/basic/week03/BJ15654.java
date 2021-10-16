package bj.comito.codeplus.basic.week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15654 {
    private static int N;
    private static int M;

    private static int[] numbers;
    private static boolean[] used;

    private static int[] picked;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final StringBuilder sb = new StringBuilder(1<<16);

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        used = new boolean[N];

        picked = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int ni = 0; ni < N; ni++) {
            numbers[ni] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        solve(0, M);

        System.out.print(sb);
    }

    private static void solve(int index, int remain) {
        if (remain == 0) {
            append();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            picked[index] = numbers[i];

            solve(index+1, remain-1);

            used[i] = false;
        }
    }

    private static void append() {
        for (int n: picked) {
            sb.append(n);
            sb.append(' ');
        }

        sb.append('\n');
    }
}
