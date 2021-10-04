package bj.solvedac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ10773 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>(N);

        long sum = 0;
        for (int ni = 0; ni < N; ni++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                sum -= queue.pop();
                continue;
            }

            queue.push(num);
            sum += num;
        }

        System.out.println(sum);
    }
}
