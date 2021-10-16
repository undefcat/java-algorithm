package bj.comito.codeplus.basic.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15649 {
    private static int N;
    private static int M;
    private static int[] picked;
    private static boolean[] used;

    private static StringBuilder sb = new StringBuilder(100_000);

    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        picked = new int[M];
        used = new boolean[N+1];

        solve(0);

        System.out.println(sb);
    }

    private static void solve(int index) {
        if (index == M) {
            printPicked();
            return;
        }

        for (int n = 1; n <= N; n++) {
            if (used[n]) {
                continue;
            }

            used[n] = true;
            picked[index] = n;
            solve(index+1);
            used[n] = false;
        }
    }

    private static void printPicked() {
        for (int i = 0; i < M; i++) {
            sb.append(picked[i]);
            sb.append(' ');
        }

        sb.append('\n');
    }
}
