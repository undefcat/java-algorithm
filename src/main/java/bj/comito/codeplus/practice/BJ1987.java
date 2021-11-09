package bj.comito.codeplus.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1987 {
    private static int Y;
    private static int X;
    private static int[][] board;
    private static int[][] visited;

    private static final int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
    };

    public static void main(String[] args) throws Throwable {
        init();

        final int startSet = 1<<board[0][0];

        System.out.println(dfs(0, 0, startSet, 1));
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        board = new int[Y][X];
        visited = new int[Y][X];
        for (int y = 0; y < Y; y++) {
            byte[] line = br.readLine().getBytes();

            for (int x = 0; x < X; x++) {
                board[y][x] = (int)(line[x] - 'A');
            }
        }

        br.close();
    }

    private static int dfs(int y, int x, int set, int cost) {
        if (visited[y][x] == set || cost == 26) {
            return cost;
        }

        visited[y][x] = set;

        int ans = cost;
        for (int[] dir: dirs) {
            final int nextY = dir[0] + y;
            final int nextX = dir[1] + x;

            if (isOutOfIndex(nextY, nextX)) {
                continue;
            }

            if (isExistAlpha(nextY, nextX, set)) {
                continue;
            }

            final int nextSet = set | (1<<board[nextY][nextX]);

            ans = Math.max(ans, dfs(nextY, nextX, nextSet, cost+1));
        }

        return ans;
    }

    static boolean isOutOfIndex(int y, int x) {
        return y < 0 || y >= Y || x < 0 || x >= X;
    }

    static boolean isExistAlpha(int y, int x, int set) {
        return (set & (1<<board[y][x])) > 0;
    }
}
