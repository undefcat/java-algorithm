package bj.star;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2440 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = N; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                sb.append('*');
            }

            sb.append('\n');
        }

        br.close();

        System.out.print(sb);
    }
}
