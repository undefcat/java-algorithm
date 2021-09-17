package bj.star;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2441 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int star = N; star >= 1; star--) {
            int padding = N-star;

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
