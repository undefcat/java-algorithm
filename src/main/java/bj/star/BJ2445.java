package bj.star;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2445 {
    private static final StringBuilder sb = new StringBuilder(30_000);

    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            appendLine(i, N-i);
        }

        appendLine(N, 0);

        for (int i = N-1; i >= 1; i--) {
            appendLine(i, N-i);
        }

        System.out.print(sb);
    }

    private static void appendLine(int star, int space) {
        sb.append("*".repeat(star));
        sb.append(" ".repeat(space));
        sb.append(" ".repeat(space));
        sb.append("*".repeat(star));

        sb.append('\n');
    }
}
