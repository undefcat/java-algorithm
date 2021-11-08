package bj.comito.codeplus.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ15558 {
    private static final byte DANGER = '0';
    private static final byte SAFETY = '1';
    private static final boolean[][] visited = new boolean[2][100_001];
    private static final byte[][] lines = new byte[2][];

    private static int N;
    private static int K;

    public static void main(String[] args) throws Throwable {
        init();
        System.out.println(bfs());
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 111_111
        );

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken());

        lines[0] = br.readLine().getBytes();
        lines[1] = br.readLine().getBytes();

        br.close();
    }

    private static String bfs() {
        Deque<State> q = new LinkedList<>();

        // 방향, 위치, 시간(초)
        q.offer(new State(0, 0, -1));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            State next = cur.front();
            if (next != null) {
                q.offer(next);
                next.checkVisited();
            }

            next = cur.back();
            if (next != null) {
                q.offer(next);
                next.checkVisited();
            }

            next = cur.jump();
            if (next != null) {
                q.offer(next);
                next.checkVisited();
            }
        }

        return "0";
    }

    static class State {
        final int dir;
        final int position;
        final int time;

        public State(int dir, int position, int time) {
            this.dir = dir;
            this.position = position;
            this.time = time;
        }

        public State front() {
            final int nextPosition = position + 1;

            if (nextPosition > N) {
                goal();
            }

            if (isOutOfIndex(nextPosition)) {
                return null;
            }

            if (visited[dir][nextPosition]) {
                return null;
            }

            if (isDanger(dir, nextPosition)) {
                return null;
            }

            return new State(dir, nextPosition, time + 1);
        }

        public State back() {
            final int nextPosition = position - 1;
            final int nextTime = time + 1;
            if (nextTime >= nextPosition) {
                return null;
            }

            if (isOutOfIndex(nextPosition)) {
                return null;
            }

            if (visited[dir][nextPosition]) {
                return null;
            }

            if (isDanger(dir, nextPosition)) {
                return null;
            }

            return new State(dir, nextPosition, nextTime);
        }

        public State jump() {
            final int nextDir = (dir + 1) % 2;
            final int nextPosition = position + K;

            if (nextPosition > N) {
                goal();
            }

            if (isOutOfIndex(nextPosition)) {
                return null;
            }

            if (visited[nextDir][nextPosition]) {
                return null;
            }

            if (isDanger(nextDir, nextPosition)) {
                return null;
            }

            return new State(nextDir, nextPosition, time + 1);
        }

        public void checkVisited() {
            visited[dir][position] = true;
        }

        private static boolean isOutOfIndex(int position) {
            return position < 0 || position > N;
        }

        private static boolean isDanger(int dir, int position) {
            return lines[dir][position] == DANGER;
        }

        private static void goal() {
            System.out.println("1");
            System.exit(0);
        }
    }
}
