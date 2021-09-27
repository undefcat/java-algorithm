package bj.thirdweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1978 {
    private static final int MAX_N = 1_000;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        boolean[] sieve = getSieve();

        int answer = 0;
        for (int n = 0; n < N; n++) {
            int number = Integer.parseInt(st.nextToken());
            answer += sieve[number] ? 1 : 0;
        }

        System.out.println(answer);
    }

    private static boolean[] getSieve() {
        boolean[] sieve = new boolean[MAX_N+1];
        Arrays.fill(sieve, true);

        sieve[0] = false;
        sieve[1] = false;

        for (int n = 2; n <= MAX_N; n++) {
            if (!sieve[n]) {
                continue;
            }

            for (int i = n*n; i <= MAX_N; i += n) {
                sieve[i] = false;
            }
        }

        return sieve;
    }
}
