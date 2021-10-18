package bj.comito.codeplus.basic.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {
    private static final byte ROAD = '0';
    private static final byte WALL = '1';

    private static final int NO_BREAK = 0;
    private static final int BREAK = 1;

    private static final int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
    };

    private static byte[][] map;
    private static boolean[][][] isVisited;

    private static int Y; // N
    private static int X; // M

    public static void main(String[] args) throws Throwable {
        input();

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
        isVisited = new boolean[Y][X][2];

        for (int y = 0; y < Y; y++) {
            map[y] = br.readLine().getBytes();
        }

    }

    private static int bfs() {
        final Queue<State> q = new LinkedList<>();

        final int destY = Y - 1;
        final int destX = X - 1;

        q.offer(new State(0, 0, 1, NO_BREAK));
        isVisited[0][0][NO_BREAK] = true;

        while (!q.isEmpty()) {
            final State cur = q.poll();

            if (cur.isArrived()) {
                return cur.dist;
            }

            for (final int[] dir: dirs) {
                final int nextY = dir[0] + cur.y;
                final int nextX = dir[1] + cur.x;

                if (isOutOfIndex(nextY, nextX)) {
                    continue;
                }

                switch (map[nextY][nextX]) {
                    case WALL:
                        if (!isVisited[nextY][nextX][BREAK] && cur.canBreakWall()) {
                            isVisited[nextY][nextX][BREAK] = true;

                            q.offer(cur.goWithBreak(nextY, nextX));
                            continue;
                        }

                        break;

                    case ROAD:
                        if (isVisited[nextY][nextX][cur.breakStatus]) {
                            continue;
                        }

                        isVisited[nextY][nextX][cur.breakStatus] = true;
                        q.offer(cur.go(nextY, nextX));
                }
            }
        }

        return -1;
    }

    private static boolean isOutOfIndex(int y, int x) {
        return y < 0 || y >= Y || x < 0 || x >= X;
    }

    static class State {
        public final int y;
        public final int x;
        public final int dist;
        public final int breakStatus;

        public State(int y, int x, int dist, int breakStatus) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.breakStatus = breakStatus;
        }

        public boolean isArrived() {
            return y == Y-1 && x == X-1;
        }

        public boolean canBreakWall() {
            return breakStatus == NO_BREAK;
        }

        public State go(int y, int x) {
            return new State(y, x, dist+1, breakStatus);
        }

        public State goWithBreak(int y, int x) {
            return new State(y, x, dist+1, BREAK);
        }
    }
}
