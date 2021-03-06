package bj.tier.gold2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12100_1 {
    private static final int[] UP = {-1, 0};
    private static final int[] RIGHT = {0, 1};
    private static final int[] DOWN = {1, 0};
    private static final int[] LEFT = {0, -1};

    private static int N;
    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws Throwable {
        Board board = input();

        move(board, 5);

        System.out.println(ans);
    }

    private static Board input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        N = Integer.parseInt(br.readLine());

        final int[][] board = new int[N][N];

        for (int ni = 0; ni < N; ni++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int nj = 0; nj < N; nj++) {
                board[ni][nj] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        return new Board(board);
    }

    private static void move(Board board, int remain) {
        if (remain == 0) {
            return;
        }

        final int nextRemain = remain - 1;

        move(board.up(), nextRemain);
        move(board.right(), nextRemain);
        move(board.down(), nextRemain);
        move(board.left(), nextRemain);
    }

    static class Board {
        private final int[][] board;

        public Board(int[][] board) {
            this.board = board;
        }

        public Board up() {
            return copy().moveUp();
        }

        private Board moveUp() {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    moveBlock(UP, y, x);
                }
            }

            return this;
        }

        public Board down() {
            return copy().moveDown();
        }

        private Board moveDown() {
            for (int y = N-1; y >= 0; y--) {
                for (int x = 0; x < N; x++) {
                    moveBlock(DOWN, y, x);
                }
            }

            return this;
        }

        public Board left() {
            return copy().moveLeft();
        }

        private Board moveLeft() {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    moveBlock(LEFT, y, x);
                }
            }

            return this;
        }

        public Board right() {
            return copy().moveRight();
        }

        private Board moveRight() {
            for (int y = 0; y < N; y++) {
                for (int x = N-1; x >= 0; x--) {
                    moveBlock(RIGHT, y, x);
                }
            }

            return this;
        }

        private Board copy() {
            final int[][] newBoard = new int[N][N];

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    newBoard[y][x] = Math.abs(board[y][x]);
                }
            }

            return new Board(newBoard);
        }

        /**
         * y, x ????????? dir ???????????? ??????.
         *
         * @param dir ??????
         * @param y y??????
         * @param x x??????
         */
        private void moveBlock(int[] dir, int y, int x) {
            if (board[y][x] == 0) {
                return;
            }

            while (true) {
                int nextY = y + dir[0];
                int nextX = x + dir[1];

                if (isOutOfIndex(nextY, nextX)) {
                    break;
                }

                final int current = board[y][x];
                final int next = board[nextY][nextX];

                // ?????? ????????? ???????????????
                // ??? ????????? ??????.
                if (next == 0) {
                    board[nextY][nextX] = board[y][x];
                    board[y][x] = 0;

                    y = nextY;
                    x = nextX;

                    continue;
                }

                // ?????? ????????? ?????? ????????????
                // ?????????.
                // ?????? ????????? ???????????? ????????? ????????? ?????????.
                // ?????? ?????? ????????? ????????????.
                if (next == current && next > 0) {
                    board[y][x] = 0;
                    board[nextY][nextX] *= -2;

                    y = nextY;
                    x = nextX;

                    break;
                }

                // ?????? ????????? ?????? ???????????????
                // ?????????.
                break;
            }

            // ????????? ????????? ?????? ????????? ??????????????????, ??????????????? ????????????.
            ans = Math.max(ans, Math.abs(board[y][x]));
        }

        private boolean isOutOfIndex(int y, int x) {
            return y < 0 || y >= N || x < 0 || x >= N;
        }
    }
}
