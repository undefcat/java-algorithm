package bj.comito.codeplus.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11048 {
    private static int Y;
    private static int X;
    private static int[][] board;
    private static final int[][] dirs = {
            {-1, 0}, {0, -1}, {-1, -1},
    };

    public static void main(String[] args) throws Throwable {
        init();

        System.out.println(dp());
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        board = new int[Y][X];

        for (int by = 0; by < Y; by++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int bx = 0; bx < X; bx++) {
                board[by][bx] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }

    private static int dp() {
        final int[][] cache = new int[Y][X];

        // board y, board x
        for (int by = 0; by < Y; by++) {
            for (int bx = 0; bx < X; bx++) {
                cache[by][bx] = board[by][bx];

                for (int[] dir: dirs) {
                    // cache y, cache x
                    final int cy = by + dir[0];
                    final int cx = bx + dir[1];

                    if (isOutOfIndex(cy, cx)) {
                        continue;
                    }

                    cache[by][bx] = Math.max(cache[by][bx], cache[cy][cx] + board[by][bx]);
                }
            }
        }

        return cache[Y-1][X-1];
    }

    private static boolean isOutOfIndex(int y, int x) {
        return y < 0 || y >= Y || x < 0 || x >= X;
    }
}
