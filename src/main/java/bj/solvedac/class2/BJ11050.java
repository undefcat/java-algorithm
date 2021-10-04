package bj.solvedac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11050 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int result = 1;
        for (int k = 0; k < K; k++) {
            result *= (N - k);
        }

        System.out.println(result/factorial(K));
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        int result = 1;
        for (int ni = 2; ni <= n; ni++) {
            result *= ni;
        }

        return result;
    }
}
