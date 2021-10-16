package bj.comito.codeplus.basic.week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ2667 {
    private static int N;
    private static byte[][] map;

    private static final PriorityQueue<Integer> pq = new PriorityQueue<>(25*25);

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        N = Integer.parseInt(br.readLine());
        map = new byte[N][N];

        for (int ni = 0; ni < N; ni++) {
            map[ni] = br.readLine().getBytes();
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                int result = visit(y, x);
                if (result > 0) {
                    pq.add(result);
                }
            }
        }

        System.out.println(pq.size());

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

    private static int visit(int y, int x) {
        if (isOutOfIndex(y, x)) {
            return 0;
        }

        if (map[y][x] == '0') {
            return 0;
        }

        map[y][x] = '0';

        int visit = 1;

        visit += visit(y-1, x);
        visit += visit(y+1, x);
        visit += visit(y, x-1);
        visit += visit(y, x+1);

        return visit;
    }

    private static boolean isOutOfIndex(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }
}
