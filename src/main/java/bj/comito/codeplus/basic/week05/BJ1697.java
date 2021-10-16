package bj.comito.codeplus.basic.week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1697 {
    private static int N;
    private static int K;

    private static final boolean[] visited = new boolean[200_001];

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<10
    );

    public static void main(String[] args) throws Throwable {
        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        final Queue<State> q = new LinkedList<>();

        q.offer(new State(N, 0));
        visited[N] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.position == K) {
                return cur.time;
            }

            if (cur.canBack()) {
                q.offer(cur.back().checkVisited());
            }

            if (cur.canFront()) {
                q.offer(cur.front().checkVisited());
            }

            if (cur.canTeleport()) {
                q.offer(cur.teleport().checkVisited());
            }
        }

        throw new RuntimeException("UNREACHABLE CODE");
    }

    static class State {
        public final int position;
        public final int time;

        public State(int position, int time) {
            this.position = position;
            this.time = time;
        }

        public boolean canBack() {
            int next = position - 1;
            if (next < 0) {
                return false;
            }

            return !visited[next];
        }

        public State back() {
            return new State(position-1, time+1);
        }

        public boolean canFront() {
            int next = position + 1;
            if (next > 200_000) {
                return false;
            }

            return !visited[next];
        }

        public State front() {
            return new State(position+1, time+1);
        }

        public boolean canTeleport() {
            int next = position * 2;
            if (next > 200_000) {
                return false;
            }

            return !visited[next];
        }

        public State teleport() {
            return new State(position*2, time+1);
        }

        public State checkVisited() {
            visited[position] = true;

            return this;
        }
    }
}
