package bj.star;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2444 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N; i++) {
            int padding = N - i;
            int star = 2*i - 1;

            printLine(sb, padding, star);
        }

        printLine(sb, 0, 2*N - 1);


        for (int i = 1; i < N; i++) {
            int padding = i;
            int star = (2*N - 1) - 2*i;

            printLine(sb, padding, star);
        }

        br.close();

        System.out.print(sb);
    }

    private static void printLine(StringBuilder sb, int padding, int star) {
        for (int p = 0; p < padding; p++) {
            sb.append(' ');
        }

        for (int s = 0; s < star; s++) {
            sb.append('*');
        }

        sb.append('\n');
    }
}
