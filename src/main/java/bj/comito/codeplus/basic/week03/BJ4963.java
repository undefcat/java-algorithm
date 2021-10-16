package bj.comito.codeplus.basic.week03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ4963 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            final int w = Integer.parseInt(st.nextToken());
            final int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            Solver solver = new Solver(w, h);

            bw.write(Integer.toString(solver.solve()));
            bw.write('\n');
        }

        bw.flush();
    }

    static class Solver {
        private final int W;
        private final int H;

        private final boolean[][] visited;

        Solver(int W, int H) throws Throwable {
            this.W = W;
            this.H = H;
            this.visited = new boolean[H][W];

            for (int h = 0; h < H; h++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for (int w = 0; w < W; w++) {
                    visited[h][w] = st.nextToken().equals("0");
                }
            }
        }

        public int solve() {
            int count = 0;

            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    if (visited[y][x]) {
                        continue;
                    }

                    count++;
                    visit(y, x);
                }
            }

            return count;
        }

        private void visit(int y, int x) {
            if (isOutOfIndex(y, x)) {
                return;
            }

            if (visited[y][x]) {
                return;
            }

            visited[y][x] = true;

            visit(y-1, x);
            visit(y+1, x);
            visit(y, x-1);
            visit(y, x+1);

            visit(y-1, x-1);
            visit(y-1, x+1);
            visit(y+1, x-1);
            visit(y+1, x+1);
        }

        private boolean isOutOfIndex(int y, int x) {
            return y < 0 || y >= H || x < 0 || x >= W;
        }
    }
}
