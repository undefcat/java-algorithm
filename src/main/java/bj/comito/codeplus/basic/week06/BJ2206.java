package bj.comito.codeplus.basic.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {
    private static final byte ROAD = '0';
    private static final byte WALL = '1';

    private static final int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
    };

    private static byte[][] map;

    private static int Y; // N
    private static int X; // M

    public static void main(String[] args) throws Throwable {
        input();

        breakWallOnce();

        System.out.println(bfs());
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new byte[Y][X];

        for (int y = 0; y < Y; y++) {
            map[y] = br.readLine().getBytes();
        }
    }

    private static void breakWallOnce() {
        final Queue<int[]> q = new LinkedList<>();
        final boolean[][] isVisited = new boolean[Y][X];

        q.offer(new int[]{0, 0, 1});
        isVisited[0][0] = true;

        while (!q.isEmpty()) {
            final int[] cur = q.poll();

            for (final int[] dir: dirs) {
                final int y = cur[0] + dir[0];
                final int x = cur[1] + dir[1];

                if (isOutOfIndex(y, x)) {
                    continue;
                }

                if (isVisited[y][x]) {
                    continue;
                }

                isVisited[y][x] = true;

                if (map[y][x] == WALL) {
                    map[y][x] = ROAD;
                    continue;
                }

                q.offer(new int[]{y, x});
            }
        }
    }

    private static int bfs() {
        final Queue<int[]> q = new LinkedList<>();
        final boolean[][] isVisited = new boolean[Y][X];

        final int destY = Y - 1;
        final int destX = X - 1;

        q.offer(new int[]{0, 0, 1});
        isVisited[0][0] = true;

        while (!q.isEmpty()) {
            final int[] cur = q.poll();

            if (cur[0] == destY && cur[1] == destX) {
                return cur[2];
            }

            for (final int[] dir: dirs) {
                final int y = dir[0] + cur[0];
                final int x = dir[1] + cur[1];
                final int dist = cur[2] + 1;

                if (isOutOfIndex(y, x)) {
                    continue;
                }

                if (isVisited[y][x] || map[y][x] == WALL) {
                    continue;
                }

                isVisited[y][x] = true;

                q.offer(new int[]{y, x, dist});
            }
        }

        return -1;
    }

    private static boolean isOutOfIndex(int y, int x) {
        return y < 0 || y >= Y || x < 0 || x >= X;
    }
}
