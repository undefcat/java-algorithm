package bj.solvedac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ2164 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        final int N = Integer.parseInt(br.readLine());

        final Deque<Integer> deque = new ArrayDeque<>(N);

        for (int n = 1; n <= N; n++) {
            deque.add(n);
        }

        while (deque.size() > 1) {
            deque.remove();
            deque.addLast(deque.remove());
        }

        System.out.println(deque.remove());
    }
}
