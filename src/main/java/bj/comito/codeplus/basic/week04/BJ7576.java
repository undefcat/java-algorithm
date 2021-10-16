package bj.comito.codeplus.basic.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {
    private static int X;
    private static int Y;

    private static final int EMPTY = -1;
    private static final int UNRIPENESS = 0;
    private static final int RIPENESS = 1;

    private static final int[][] delta = {
        {0, 1}, {0, -1}, {-1, 0}, {1, 0},
    };

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int remain = 0;

        Queue<int[]> today = new ArrayDeque<>(1<<10);
        Queue<int[]> tomorrow = new ArrayDeque<>(1<<10);

        final int[][] storage = new int[Y][X];

        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int x = 0; x < X; x++) {
                int tomato = Integer.parseInt(st.nextToken());
                storage[y][x] = tomato;

                switch (tomato) {
                    case UNRIPENESS:
                        remain++;
                        continue;

                    case RIPENESS:
                        today.add(new int[]{y, x});
                }
            }
        }

        // 이미 다 익어있다면
        if (remain == 0) {
            System.out.println(0);
            return;
        }

        // 시작은 0일부터이므로
        // -1로 시작
        int day = -1;
        while (!today.isEmpty()) {
            day++;

            while (!today.isEmpty()) {
                int[] coord = today.remove();

                // 탐색
                for (int[] d: delta) {
                    int y = d[0] + coord[0];
                    int x = d[1] + coord[1];

                    if (isOutOfIndex(y, x)) {
                        continue;
                    }

                    if (storage[y][x] == UNRIPENESS) {
                        storage[y][x] = RIPENESS;
                        tomorrow.add(new int[]{y, x});
                        remain--;
                    }
                }
            }

            Queue<int[]> tmp;

            tmp = today;
            today = tomorrow;
            tomorrow = tmp;

        }

        if (remain > 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(day);
    }

    private static boolean isOutOfIndex(int y, int x) {
        return y < 0 || y >= Y || x < 0 || x >= X;
    }
}
