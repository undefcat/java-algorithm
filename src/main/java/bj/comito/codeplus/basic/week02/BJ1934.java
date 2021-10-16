package bj.comito.codeplus.basic.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1934 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(lcm(A, B));
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static int lcm(int a, int b) {
        int mul = a * b;

        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        while (true) {
            int r = a % b;
            if (r == 0) {
                return mul / b;
            }

            a = b;
            b = r;
        }
    }
}
