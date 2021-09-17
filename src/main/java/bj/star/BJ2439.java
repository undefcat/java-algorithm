package bj.star;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2439 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int padding = N - i;
            int star = i;

            for (int p = 0; p < padding; p++) {
                sb.append(' ');
            }

            for (int s = 0; s < star; s++) {
                sb.append('*');
            }

            sb.append('\n');
        }

        br.close();

        System.out.print(sb);
    }
}
