package bj.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ1874 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(200_000);

        Deque<Integer> stack = new ArrayDeque<>(N);

        int cur = 1;
        while (cur <= N) {
            int next = Integer.parseInt(br.readLine());

            // push phase
            if (next >= cur) {
                while (cur <= next) {
                    stack.push(cur);
                    sb.append("+\n");
                    cur++;
                }
            }

            // pop phase
            if (stack.isEmpty()) {
                System.out.println("NO");
                return;
            }

            int pop = stack.pop();
            sb.append("-\n");

            if (next != pop) {
                System.out.println("NO");
                return;
            }
        }

        while (!stack.isEmpty()) {
            int next = Integer.parseInt(br.readLine());
            int pop = stack.pop();

            if (next != pop) {
                System.out.println("NO");
                return;
            }

            sb.append("-\n");
        }

        System.out.print(sb);
    }
}
