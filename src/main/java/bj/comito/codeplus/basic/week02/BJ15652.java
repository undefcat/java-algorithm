package bj.comito.codeplus.basic.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15652 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final StringBuilder sb = new StringBuilder(100_000);

    private static int N;
    private static int M;

    private static int[] picked;

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        picked = new int[M];

        solve(0, 1);

        System.out.print(sb);
    }

    private static void solve(int index, int startNum) {
        if (index == M) {
            appendPicked();
            return;
        }

        for (int n = startNum; n <= N; n++) {
            picked[index] = n;
            solve(index+1, n);
        }
    }

    private static void appendPicked() {
        for (int i = 0; i < M; i++) {
            sb.append(picked[i]);
            sb.append(' ');
        }

        sb.append('\n');
    }
}
