package bj.comito.codeplus.practice;

import java.util.*;

public class BJ2251_1 {
    private static final boolean[][][] visited = new boolean[201][201][201];
    private static final int[][] actions = {
            {0, 1}, {0, 2},
            {1, 0}, {1, 2},
            {2, 0}, {2, 1},
    };

    private static final int[] size = new int[3];

    private static final TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws Throwable {
        init();
        bfs();

        final StringBuilder sb = new StringBuilder(1_000);

        for (int num: set) {
            sb.append(num);
            sb.append(' ');
        }

        System.out.println(sb);
    }

    private static void init() {
        final Scanner sc = new Scanner(System.in);

        size[0] = sc.nextInt();
        size[1] = sc.nextInt();
        size[2] = sc.nextInt();

        sc.close();
    }

    private static void bfs() {
        final Deque<State> q = new LinkedList<>();

        q.offer(new State(new int[]{0, 0, size[2]}));
        visited[0][0][size[2]] = true;

        set.add(size[2]);

        while (!q.isEmpty()) {
            State cur = q.poll();

            for (int[] action: actions) {
                State next = cur.pour(action[0], action[1]);
                if (next != null) {
                    q.offer(next);
                }
            }
        }
    }

    static class State {
        final int[] bucket;

        public State(int[] bucket) {
            this.bucket = bucket;
        }

        public State pour(int from, int to) {
            if (bucket[from] == 0 || bucket[to] == size[to]) {
                return null;
            }

            // 부을 수 있는 양
            final int delta = Math.min(bucket[from], size[to] - bucket[to]);
            final int[] nextBucket = Arrays.copyOf(bucket, 3);

            nextBucket[from] -= delta;
            nextBucket[to] += delta;

            if (isVisited(nextBucket)) {
                return null;
            }

            checkVisited();

            if (nextBucket[0] == 0) {
                set.add(nextBucket[2]);
            }

            return new State(nextBucket);
        }

        private static boolean isVisited(int[] bucket) {
            return visited[bucket[0]][bucket[1]][bucket[2]];
        }

        public void checkVisited() {
            visited[bucket[0]][bucket[1]][bucket[2]] = true;
        }
    }
}
