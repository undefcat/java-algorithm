package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2606 {
    private static Computer[] computers;

    public static void main(String[] args) throws Throwable {
        input();

        System.out.println(bfs());
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());

        computers = new Computer[N+1];
        for (int ni = 1; ni <= N; ni++) {
            computers[ni] = new Computer(ni);
        }

        for (int mi = 0; mi < M; mi++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            final int from = Integer.parseInt(st.nextToken());
            final int to = Integer.parseInt(st.nextToken());

            computers[from].add(to);
            computers[to].add(from);
        }

        br.close();
    }

    private static int bfs() {
        Queue<Integer> q = new ArrayDeque<>(computers.length);

        q.offer(1);
        computers[1].visit();

        int count = 0;
        while (!q.isEmpty()) {
            final int from = q.poll();

            for (final int next: computers[from].siblings) {
                if (computers[next].isVisited()) {
                    continue;
                }

                computers[next].visit();
                q.offer(next);

                count++;
            }
        }

        return count;
    }

    static class Computer {
        private final int id;
        private final List<Integer> siblings = new LinkedList<>();

        private boolean visited;

        public Computer(int id) {
            this.id = id;
        }

        public void add(int id) {
            siblings.add(id);
        }

        public boolean isVisited() {
            return visited;
        }

        public void visit() {
            visited = true;
        }
    }
}
