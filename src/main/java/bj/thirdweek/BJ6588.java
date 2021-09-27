package bj.thirdweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ6588 {
    private static final int MAX_VALUE = 1_000_000;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final StringBuilder sb = new StringBuilder(1_000_000);

    public static void main(String[] args) throws Throwable {
        boolean[] sieve = getSieve();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            for (int a = 3; a < n ; a += 2) {
                if (!sieve[a]) {
                    continue;
                }

                int b = n - a;
                if (!sieve[b]) {
                    continue;
                }

                appendAnswer(n, a, b);
                break;
            }
        }

        System.out.print(sb);
    }

    private static boolean[] getSieve() {
        boolean[] sieve = new boolean[MAX_VALUE];

        Arrays.fill(sieve, true);

        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i < MAX_VALUE; i++) {
            if (sieve[i]) {

                long end = (long)i * (long)i;
                for (long j = end; j < MAX_VALUE; j += i) {
                    sieve[(int)j] = false;
                }
            }
        }

        return sieve;
    }

    private static void appendAnswer(int n, int a, int b) {
        sb.append(n);
        sb.append(" = ");
        sb.append(a);
        sb.append(" + ");
        sb.append(b);
        sb.append('\n');
    }
}
