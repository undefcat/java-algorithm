package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ7569 {
    private static final int EMPTY = -1;
    private static final int DO = 0;
    private static final int DONE = 1;

    private static int Z;
    private static int Y;
    private static int X;

    private static int remain = 0;

    private static int[][][] box;

    private final static int[][] dirs = {
            {-1, 0, 0}, {1, 0, 0},
            {0, -1, 0}, {0, 1, 0},
            {0, 0, -1}, {0, 0, 1},
    };

    public static void main(String[] args) throws Throwable {
        List<State> start = init();

        if (remain == 0) {
            System.out.print(0);
            return;
        }

        final int result = bfs(start);

        if (remain == 0) {
            System.out.print(result);
            return;
        }

        System.out.print(-1);
    }

    private static List<State> init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());

        box = new int[Z][Y][X];

        List<State> start = new LinkedList<>();

        for (int z = 0 ; z < Z; z++) {
            for (int y = 0; y < Y; y++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int x = 0; x < X; x++) {
                    final int status = Integer.parseInt(st.nextToken());

                    switch (status) {
                        case DO:
                            remain++;
                            break;

                        case DONE:
                            start.add(new State(z, y, x, 0));
                            break;
                    }

                    box[z][y][x] = status;
                }
            }
        }

        br.close();

        return start;
    }

    private static int bfs(List<State> start) {
        Queue<State> q = new ArrayDeque<>(Z * Y * X + 1);

        q.addAll(start);

        int lastDay = -1;
        while (!q.isEmpty()) {
            State cur = q.poll();

            lastDay = cur.day;

            for (int[] dir: dirs) {
                State next = cur.next(dir);

                if (next.isOutOfIndex()) {
                    continue;
                }

                if (!next.canUsed()) {
                    continue;
                }

                next.setDone();

                q.offer(next);
            }
        }

        return lastDay;
    }

    static class State {
        final int z;
        final int y;
        final int x;
        final int day;

        public State(int z, int y, int x, int day) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.day = day;
        }

        public State next(int[] dir) {
            return new State(z + dir[0], y + dir[1], x + dir[2], day + 1);
        }

        public boolean isOutOfIndex() {
            return (z < 0 || z >= Z) || (y < 0 || y >= Y) || (x < 0 || x >= X);
        }

        public boolean canUsed() {
            return box[z][y][x] == DO;
        }

        public void setDone() {
            box[z][y][x] = DONE;
            remain--;
        }
    }
}
