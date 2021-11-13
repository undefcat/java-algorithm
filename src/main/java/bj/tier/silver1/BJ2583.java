package bj.tier.silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2583 {
    private static int Y;
    private static int X;
    private static boolean[][] area;

    private static final int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
    };

    public static void main(String[] args) throws Throwable {
        init();

        System.out.println(solve());
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        final int K = Integer.parseInt(st.nextToken());

        area = new boolean[Y][X];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine(), " ");

            final int x0 = Integer.parseInt(st.nextToken());
            final int y0 = Integer.parseInt(st.nextToken());

            final int x1 = Integer.parseInt(st.nextToken());
            final int y1 = Integer.parseInt(st.nextToken());

            for (int y = y0; y < y1; y++) {
                for (int x = x0; x < x1; x++) {
                    area[y][x] = true;
                }
            }
        }

        br.close();
    }

    private static String solve() {
        List<Integer> sizes = new LinkedList<>();

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                final int size = dfs(y, x);

                if (size == 0) {
                    continue;
                }

                sizes.add(size);
            }
        }

        Collections.sort(sizes);

        StringBuilder sb = new StringBuilder();

        sb.append(sizes.size());
        sb.append('\n');

        for (int size: sizes) {
            sb.append(size);
            sb.append(' ');
        }

        return sb.toString();
    }

    private static int dfs(int y, int x) {
        if (area[y][x]) {
            return 0;
        }

        area[y][x] = true;

        int size = 1;
        for (int[] dir: dirs) {
            final int ny = dir[0] + y;
            final int nx = dir[1] + x;

            if (isOutOfIndex(ny, nx)) {
                continue;
            }

            size += dfs(ny, nx);
        }

        return size;
    }

    private static boolean isOutOfIndex(int y, int x) {
        return y < 0 || y >= Y || x < 0 || x >= X;
    }
}
