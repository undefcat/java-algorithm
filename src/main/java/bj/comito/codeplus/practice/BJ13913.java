package bj.comito.codeplus.practice;

import java.util.*;

public class BJ13913 {
    private static int N;
    private static int K;

    private static final int UNVISITED = -1;
    private static final int START = Integer.MAX_VALUE;
    private static final int[] visited = new int[200_001];

    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        Arrays.fill(visited, UNVISITED);

        System.out.println(bfs());
        System.out.println(path());
    }

    private static int bfs() {
        final Queue<State> q = new LinkedList<>();

        q.offer(new State(N, 0, N));
        visited[N] = START;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.position == K) {
                return cur.time;
            }

            if (cur.canBack()) {
                q.offer(cur.back(cur.position).checkVisited());
            }

            if (cur.canFront()) {
                q.offer(cur.front(cur.position).checkVisited());
            }

            if (cur.canTeleport()) {
                q.offer(cur.teleport(cur.position).checkVisited());
            }
        }

        throw new RuntimeException("UNREACHABLE CODE");
    }

    private static String path() {
        Deque<Integer> q = new LinkedList<>();

        int position = K;

        while (position != START) {
            q.push(position);
            position = visited[position];
        }

        final StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            sb.append(q.pop());
            sb.append(' ');
        }

        return sb.toString();
    }

    static class State {
        public final int position;
        public final int time;
        public final int from;

        public State(int position, int time, int from) {
            this.position = position;
            this.time = time;
            this.from = from;
        }

        public boolean canBack() {
            int next = position - 1;
            if (next < 0) {
                return false;
            }

            return visited[next] == UNVISITED;
        }

        public State back(int from) {
            return new State(position-1, time+1, from);
        }

        public boolean canFront() {
            int next = position + 1;
            if (next > 200_000) {
                return false;
            }

            return visited[next] == UNVISITED;
        }

        public State front(int from) {
            return new State(position+1, time+1, from);
        }

        public boolean canTeleport() {
            int next = position * 2;
            if (next > 200_000) {
                return false;
            }

            return visited[next] == UNVISITED;
        }

        public State teleport(int from) {
            return new State(position*2, time+1, from);
        }

        public State checkVisited() {
            visited[position] = from;

            return this;
        }
    }
}
