package bj.secondweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14500 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    // {y, x}
    private static final int[][][] blocks = {
            {{0, 0}, {0, 1}, {-1, 1}, {0, 2}}, // ㅗ
            {{0, 0}, {1, 0}, {1, 1}, {2, 0}}, // ㅏ
            {{0, 0}, {0, 1}, {1, 1}, {2, 0}}, // ㅜ
            {{0, 0}, {0, 1}, {-1, 1}, {1, 1}}, // ㅓ
    };

    private static int BOARD_Y;
    private static int BOARD_X;

    private static int[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        BOARD_Y = Integer.parseInt(st.nextToken());
        BOARD_X = Integer.parseInt(st.nextToken());

        board = new int[BOARD_Y][BOARD_X];
        visited = new boolean[BOARD_Y][BOARD_X];

        for (int y = 0; y < BOARD_Y; y++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int x = 0; x < BOARD_X; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int y = 0; y < BOARD_Y; y++) {
            for (int x = 0; x < BOARD_X; x++) {
                ans = Math.max(ans, putBlockDfs(x, y, 4, 0));
                ans = Math.max(ans, putBlocks(x, y));
            }
        }

        System.out.println(ans);
    }

    private static boolean isOutOfIndex(int x, int y) {
        return x < 0 || x >= BOARD_X || y < 0 || y >= BOARD_Y;
    }

    private static int putBlocks(int bx, int by) {
        int ret = 0;

        out:
        for (int blockType = 0; blockType < 4; blockType++) {
            int[][] block = blocks[blockType];
            int sum = 0;

            for (int b = 0; b < 4; b++) {
                int y = by + block[b][0];
                int x = bx + block[b][1];

                if (isOutOfIndex(x, y)) {
                    continue out;
                }

                sum += board[y][x];
            }

            ret = Math.max(ret, sum);
        }

        return ret;
    }

    private static int putBlockDfs(int x, int y, int remain, int sum) {
        if (remain == 0) {
            return sum;
        }

        if (isOutOfIndex(x, y)) {
            return 0;
        }

        if (visited[y][x]) {
            return 0;
        }

        int ret = 0;
        int nextRemain = remain-1;
        int nextSum = sum + board[y][x];

        visited[y][x] = true;

        ret = Math.max(ret, putBlockDfs(x-1, y, nextRemain, nextSum));
        ret = Math.max(ret, putBlockDfs(x+1, y, nextRemain, nextSum));
        ret = Math.max(ret, putBlockDfs(x, y-1, nextRemain, nextSum));
        ret = Math.max(ret, putBlockDfs(x, y+1, nextRemain, nextSum));

        visited[y][x] = false;

        return ret;
    }
}
