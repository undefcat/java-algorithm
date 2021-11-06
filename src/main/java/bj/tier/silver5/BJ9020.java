package bj.tier.silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ9020 {
    private static boolean[] isPrime = new boolean[10_001];

    public static void main(String[] args) throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out), 1<< 10
        );

        doSieve();

        final int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            final int target = Integer.parseInt(br.readLine());
            final int end = target / 2;

            int diff = Integer.MAX_VALUE;
            int candiA = 0;
            int candiB = 0;

            for (int a = 2; a <= end; a++) {
                if (!isPrime[a]) {
                    continue;
                }

                final int b = target - a;

                if (!isPrime[b]) {
                    continue;
                }

                if (b < diff) {
                    diff = b;
                    candiA = a;
                    candiB = b;
                }
            }

            bw.write(Integer.toString(candiA));
            bw.write(' ');
            bw.write(Integer.toString(candiB));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void doSieve() {
        isPrime[0] = false;
        isPrime[1] = false;

        for (int n = 2; n <= 10_000; n++) {
            if (!isPrime[n]) {
                continue;
            }

            for (int m = n*n; m <= 10_000; m += n) {
                isPrime[m] = false;
            }
        }
    }
}
