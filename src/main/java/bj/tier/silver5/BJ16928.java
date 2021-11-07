package bj.tier.silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ16928 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<10
    );

    private static final int[] board = new int[101];
    private static final boolean[] visited = new boolean[101];

    public static void main(String[] args) throws Throwable {
        init();

        br.close();

        System.out.println(bfs());
    }

    private static void init() throws Throwable {
        for (int n = 1; n <= 100; n++) {
            board[n] = n;
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int ladderSnakes = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        for (int i = 0; i < ladderSnakes; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            final int from = Integer.parseInt(st.nextToken());
            final int to = Integer.parseInt(st.nextToken());

            board[from] = to;
        }
    }

    private static int bfs() {
        Deque<int[]> q = new LinkedList<>();

        q.offer(new int[]{1, 0});
        visited[0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dice = 1; dice <= 6; dice++) {
                int to = cur[0] + dice;

                if (to == 100) {
                    return cur[1] + 1;
                }

                to = board[to];

                if (visited[to]) {
                    continue;
                }

                visited[to] = true;

                q.offer(new int[]{to, cur[1] + 1});
            }
        }

        throw new RuntimeException("UNREACHABLE CODE");
    }
}
