package bj.comito.codeplus.practice;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ12851 {
    private static int N;
    private static int K;
    private static final int[] visited = new int[200_001];

    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        sc.close();

        Arrays.fill(visited, -1);

        solve();
    }

    private static void solve() {
        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }

        Deque<State> q = new LinkedList<>();

        q.offer(new State(N, 0));
        visited[N] = 0;

        int time = Integer.MAX_VALUE;
        int count = 0;
        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.time > time) {
                break;
            }

            if (cur.position == K) {
                time = cur.time;
                count++;
                continue;
            }

            State next;

            next = cur.back();
            if (next != null) {
                q.offer(next);
                next.checkVisit();
            }

            next = cur.front();
            if (next != null) {
                q.offer(next);
                next.checkVisit();
            }

            next = cur.teleport();
            if (next != null) {
                q.offer(next);
                next.checkVisit();
            }
        }

        System.out.println(time);
        System.out.println(count);
    }

    static class State {
        final int time;
        final int position;

        public State(int position, int time) {
            this.position = position;
            this.time = time;
        }

        public State back() {
            final int pos = position - 1;
            final int nextTime = time + 1;

            if (!canVisit(pos, nextTime)) {
                return null;
            }

            return new State(pos, nextTime);
        }

        public State front() {
            final int pos = position + 1;
            final int nextTime = time + 1;
            if (!canVisit(pos, nextTime)) {
                return null;
            }

            return new State(pos, nextTime);
        }

        public State teleport() {
            final int pos = position * 2;
            final int nextTime = time + 1;

            if (!canVisit(pos, nextTime)) {
                return null;
            }

            return new State(pos, nextTime);
        }

        public static boolean canVisit(int pos, int time) {
            if (isOutOfIndex(pos)) {
                return false;
            }

            if (visited[pos] == -1) {
                return true;
            }

            return visited[pos] == time;
        }

        public void checkVisit() {
            visited[position] = time;
        }

        private static boolean isOutOfIndex(int pos) {
            return pos < 0 || pos > 200_000;
        }
    }
}
