package bj.comito.codeplus.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1107 {
    private static final boolean[] broken = new boolean[10];

    private static int target;
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Throwable {
        init();

        solveFirst();

        if (ans == 0) {
            System.out.println(0);
            return;
        }

        solveBruteForce();

        System.out.println(ans);
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        target = Integer.parseInt(br.readLine());

        final int M = Integer.parseInt(br.readLine());

        if (M > 0) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int mi = 0; mi < M; mi++) {
                final int brokenNumber = Integer.parseInt(st.nextToken());

                broken[brokenNumber] = true;
            }
        }

        br.close();
    }

    // +, - 버튼으로 정답에 가본다.
    private static void solveFirst() {
        ans = Math.abs(100 - target);
    }

    // 주어진 버튼들로 정답을 다 만들어본다.
    private static void solveBruteForce() {
        pick(1, 0);
    }

    private static void pick(int n, final int current) {
        // 500,000 까지 이므로
        // 최대 6 숫자를 만들어 보면 된다.
        if (n > 6) {
            return;
        }

        for (int num = 0; num < 10; num++) {
            if (broken[num]) {
                continue;
            }

            final int nextCurrent = current * 10 + num;

            ans = Math.min(ans, Math.abs(target - nextCurrent) + n);
            pick(n + 1, nextCurrent);
        }
    }
}
