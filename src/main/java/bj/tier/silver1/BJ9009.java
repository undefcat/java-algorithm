package bj.tier.silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BJ9009 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<5
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<10
    );

    private static int[] fibo = new int[43];

    private static Deque<Integer> deque = new ArrayDeque<>(50);

    public static void main(String[] args) throws Throwable {
        init();

        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<5
        );

        final int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            solve(Integer.parseInt(br.readLine()));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void init() {
        int a = 1;
        int b = 1;

        for (int n = 0; n < 43; n++) {
            fibo[n] = b;

            final int tmp = b;
            b = a + b;
            a = tmp;
        }
    }

    private static void solve(int n) throws Throwable {
        while (n > 0) {
            final int i = Arrays.binarySearch(fibo, n);

            if (i >= 0) {
                deque.push(fibo[i]);
                break;
            }

            final int next = Math.abs(i) - 2;
            deque.push(fibo[next]);
            n -= fibo[next];
        }

        while (!deque.isEmpty()) {
            bw.write(deque.pop().toString());
            bw.write(' ');
        }

        bw.write('\n');
    }
}
