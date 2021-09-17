package bj.secondweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15651 {
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

        solve(0);

        System.out.print(sb);
    }

    private static void solve(int index) {
        if (index == M) {
            appendPicked();
            return;
        }

        for (int n = 1; n <= N; n++) {
            picked[index] = n;
            solve(index+1);
        }
    }

    private static void appendPicked() {
        for (int n: picked) {
            sb.append(n);
            sb.append(' ');
        }

        sb.append('\n');
    }
}
