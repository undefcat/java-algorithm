package bj.comito.week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15655 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final StringBuffer sb = new StringBuffer(1<<16);

    private static int N;
    private static int M;

    private static int[] numbers;
    private static int[] picked;
    private static boolean[] used;

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        numbers = new int[N];
        used = new boolean[N];

        picked = new int[M];

        for (int ni = 0; ni < N; ni++) {
            numbers[ni] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        solve(0, 0, M);

        System.out.print(sb);
    }

    private static void solve(int cur, int index, int remain) {
        if (remain == 0) {
            append();
            return;
        }

        for (int ci = cur; ci < N; ci++) {
            if (used[ci]) {
                continue;
            }

            used[ci] = true;
            picked[index] = numbers[ci];

            solve(ci+1, index+1, remain-1);

            used[ci] = false;
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
