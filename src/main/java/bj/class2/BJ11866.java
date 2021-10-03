package bj.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ11866 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        bw.write('<');

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        final int popCount = K-1;

        final Deque<Integer> deque = new ArrayDeque<>(N);

        for (int n = 1; n <= N; n++) {
            deque.add(n);
        }

        while (deque.size() > 1) {
            for (int pi = 0; pi < popCount; pi++) {
                deque.add(deque.remove());
            }

            bw.write(deque.remove().toString());
            bw.write(", ");
        }

        bw.write(deque.remove().toString());
        bw.write('>');

        bw.flush();
        bw.close();
        br.close();
    }
}
