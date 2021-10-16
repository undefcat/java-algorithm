package bj.comito.codeplus.basic.week05;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ13549 {
    private static int N;
    private static int M;

    private static final int[] times = new int[200_001];

    public static void main(String[] args) throws Throwable {
        input();
        init();
        dijkstra();

        System.out.println(times[M]);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
    }

    private static void init() {
        Arrays.fill(times, Integer.MAX_VALUE);

        times[N] = 0;
    }

    private static void dijkstra() {
        PriorityQueue<State> pq = new PriorityQueue<>();

        pq.offer(new State(N, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            State next;

            next = cur.moveBack();
            if (next != null) {
                pq.offer(next);
            }

            next = cur.moveFront();
            if (next != null) {
                pq.offer(next);
            }

            next = cur.teleport();
            if (next != null) {
                pq.offer(next);
            }
        }
    }

    static class State implements Comparable<State> {
        public final int position;
        public final int time;

        public State(int position, int time) {
            this.position = position;
            this.time = time;
        }

        public State moveFront() {
            return doMove(position+1, time+1);
        }

        public State moveBack() {
            return doMove(position-1, time+1);
        }

        public State teleport() {
            return doMove(position*2, time);
        }

        private State doMove(int nextPosition, int totalTime) {
            boolean canMove = (nextPosition >= 0 && nextPosition <= 200_000)
                    && totalTime < times[nextPosition];

            if (!canMove) {
                return null;
            }

            times[nextPosition] = totalTime;

            return new State(nextPosition, totalTime);
        }

        @Override
        public int compareTo(State o) {
            return time - o.time;
        }
    }
}
