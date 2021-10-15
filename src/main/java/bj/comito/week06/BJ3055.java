package bj.comito.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3055 {
    private static final byte EMPTY = '.';
    private static final byte WATER = '*';
    private static final byte SOON_WATER = '#';
    private static final byte ROCK = 'X';
    private static final byte START = 'S';
    private static final byte EXIT = 'D';

    private static final int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
    };

    private static final int[] start = new int[2];
    private static final boolean[][] visited = new boolean[50][50];

    private static int Y;
    private static int X;

    private static byte[][] forest;

    public static void main(String[] args) throws Throwable {
        input();

        int result = bfs();

        if (result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        forest = new byte[Y][];

        for (int y = 0; y < Y; y++) {
            forest[y] = br.readLine().getBytes();
        }

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                switch (forest[y][x]) {
                    case START:
                        start[0] = y;
                        start[1] = x;
                        forest[y][x] = EMPTY;
                        break;

                    case WATER:
                        forest[y][x] = ROCK;
                        setSoonWater(y, x);
                }
            }
        }

        br.close();
    }

    private static int bfs() {
        final Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        int minute = 0;

        loop:
        while (!q.isEmpty()) {
            final int[] cur = q.poll();

            if (cur[2] > minute) {
                nextTick();
                minute++;
            }

            for (final int[] dir: dirs) {
                final int y = dir[0] + cur[0];
                final int x = dir[1] + cur[1];
                final int time = cur[2] + 1;

                if (!canGo(y, x)) {
                    continue;
                }

                if (forest[y][x] == EXIT) {
                    return time;
                }

                q.offer(new int[]{y, x, time});
                visited[y][x] = true;
            }
        }

        return -1;
    }

    /**
     * 물이 차오르게 한다.
     */
    private static void nextTick() {
        // 우선, 이번 틱에 물로 바뀌어야 하는 곳은 물로 바꾼다.
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (forest[y][x] == SOON_WATER) {
                    forest[y][x] = WATER;
                }
            }
        }

        // 물이었던 곳은 다음틱에 물로 바꿀 수 있도록 하고,
        // 해당 물은 더 이상 활성화 되지 않도록 ROCK으로 변경한다.
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (forest[y][x] == WATER) {
                    setSoonWater(y, x);

                    // 더 이상 SOON_WATER로
                    // 변하게 하면 안되므로
                    forest[y][x] = ROCK;
                }
            }
        }
    }

    private static void setSoonWater(int y, int x) {
        for (int[] dir: dirs) {
            int dy = y + dir[0];
            int dx = x + dir[1];

            if (isOutOfIndex(dy, dx)) {
                continue;
            }

            if (forest[dy][dx] == EMPTY) {
                forest[dy][dx] = SOON_WATER;
            }
        }
    }

    private static boolean canGo(int y, int x) {
        if (isOutOfIndex(y, x)) {
            return false;
        }

        if (visited[y][x]) {
            return false;
        }

        return forest[y][x] == EMPTY || forest[y][x] == EXIT;
    }

    private static boolean isOutOfIndex(int y, int x) {
        return y < 0 || y >= Y || x < 0 || x >= X;
    }
}
