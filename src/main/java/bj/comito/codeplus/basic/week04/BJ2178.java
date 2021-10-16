package bj.comito.codeplus.basic.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178 {
    private static final byte VISITED = '0';
    private static final byte NON_VISITED = '1';

    private static final int[][] delta = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
    };

    private static int Y;
    private static int X;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        final int END_Y = Y-1;
        final int END_X = X-1;

        final byte[][] maze = new byte[Y][X];

        for (int y = 0; y < Y; y++) {
            maze[y] = br.readLine().getBytes();
        }

        // {y, x, distance}
        Queue<int[]> q = new ArrayDeque<>(100*100);

        q.add(new int[]{0, 0, 1});
        maze[0][0] = VISITED;

        while (!q.isEmpty()) {
            int[] road = q.remove();

            for (int[] d: delta) {
                int y = d[0] + road[0];
                int x = d[1] + road[1];

                if (isOutOfIndex(y, x)) {
                    continue;
                }

                if (maze[y][x] == VISITED) {
                    continue;
                }

                int distance = road[2] + 1;

                if (y == END_Y && x == END_X) {
                    System.out.println(distance);
                    return;
                }

                maze[y][x] = VISITED;
                q.add(new int[]{y, x, distance});
            }
        }

        throw new RuntimeException("UNREACHEABLE CODE");
    }

    private static boolean isOutOfIndex(int y, int x) {
        return y < 0 || y >= Y || x < 0 || x >= X;
    }
}
