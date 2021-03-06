package bj.tier.gold2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12100_2 {
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

        Board next = board;
        for (int i = 0; i < 4; i++) {
            next = next.rotate();
            move(next.copy().up(), nextRemain);
        }
    }

    static class Board {
        private final int[][] board;

        public Board(int[][] board) {
            this.board = board;
        }

        public Board rotate() {
            final int[][] newBoard = new int[N][N];

            // 원본의 x값이 복사본의 y값이 되고
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    newBoard[y][x] = Math.abs(board[N - x - 1][y]);
                }
            }

            return new Board(newBoard);
        }

        public Board up() {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    moveUp(y, x);
                }
            }

            return this;
        }

        public Board copy() {
            final int[][] copied = new int[N][N];
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    copied[y][x] = board[y][x];
                }
            }

            return new Board(copied);
        }

        /**
         * y, x 블록을 윗쪽 방향으로 민다.
         *
         * @param y y좌표
         * @param x x좌표
         */
        private void moveUp(int y, int x) {
            if (board[y][x] == 0) {
                return;
            }

            while (true) {
                int nextY = y - 1;
                int nextX = x;

                if (isOutOfIndex(nextY, nextX)) {
                    break;
                }

                final int current = board[y][x];
                final int next = board[nextY][nextX];

                // 해당 방향이 비어있다면
                // 그 위치로 민다.
                if (next == 0) {
                    board[nextY][nextX] = board[y][x];
                    board[y][x] = 0;

                    y = nextY;
                    x = nextX;

                    continue;
                }

                // 해당 방향이 같은 블럭이면
                // 합친다.
                // 이미 합쳐진 블록이면 더이상 합치지 않는다.
                // 해당 값은 음수로 표현한다.
                if (next == current && next > 0) {
                    board[y][x] = 0;
                    board[nextY][nextX] *= -2;

                    y = nextY;
                    x = nextX;

                    break;
                }

                // 다른 블럭이 있는 경우이므로
                // 끝낸다.
                break;
            }

            // 합쳐진 블록의 값을 음수로 체크했으므로, 절댓값으로 표시한다.
            ans = Math.max(ans, Math.abs(board[y][x]));
        }

        private boolean isOutOfIndex(int y, int x) {
            return y < 0 || y >= N || x < 0 || x >= N;
        }
    }
}
