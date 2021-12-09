package bj.tier.silver1;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BJ12852 {
    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<10
    );

    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        final int[] cache = new int[N+1];

        Arrays.fill(cache, Integer.MAX_VALUE);

        cache[1] = 0;
        for (int n = 1; n < N; n++) {
            final int nextStep = cache[n] + 1;

            if (n*2 <= N) {
                cache[n*2] = Math.min(cache[n*2], nextStep);
            }

            if (n*3 <= N) {
                cache[n*3] = Math.min(cache[n*3], nextStep);
            }

            if (n+1 <= N) {
                cache[n+1] = Math.min(cache[n+1], nextStep);
            }
        }

        bw.write(Integer.toString(cache[N]));
        bw.write('\n');

        int cur = N;
        while (true) {
            bw.write(Integer.toString(cur));
            bw.write(' ');

            if (cur == 1) {
                break;
            }

            final int prevStep = cache[cur]-1;

            if (cur%3 == 0 && cache[cur/3] == prevStep) {
                cur /= 3;
                continue;
            }

            if (cur%2 == 0 && cache[cur/2] == prevStep) {
                cur /= 2;
                continue;
            }

            cur--;
        }

        bw.flush();
        bw.close();
        sc.close();
    }
}
