package bj.thirdweek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ6588 {
    private static final int MAX_VALUE = 1_000_000;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        List<Integer> primes = getSieve();
        final int SIZE = primes.size();

        loop:
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }


            for (int ai = 0; ai < SIZE; ai++) {
                int a = primes.get(ai);

                for (int bi = ai+1; bi < SIZE; bi++) {
                    int b = primes.get(bi);

                    if (a + b > n) {
                        break;
                    }

                    if (a + b == n) {
                        bw.write(String.format("%d = %d + %d", n, a, b));
                        bw.write('\n');

                        continue loop;
                    }
                }
            }
        }

        bw.flush();
    }

    private static List<Integer> getSieve() {
        boolean[] sieve = new boolean[MAX_VALUE];
        List<Integer> primes = new ArrayList<>(78_500);

        Arrays.fill(sieve, true);

        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i < MAX_VALUE; i++) {
            if (sieve[i]) {
                primes.add(i);

                long end = (long)i * (long)i;
                for (long j = end; j < MAX_VALUE; j += i) {
                    sieve[(int)j] = false;
                }
            }
        }

        return primes;
    }
}
