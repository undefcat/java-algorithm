package bj.tier.silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1926 {
    private static final boolean NONE = false;
    private static final boolean VISITED = true;

    private static final int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
    };

    private static int Y;
    private static int X;
    private static boolean[][] pictures;

    public static void main(String[] args) throws Throwable {
        init();
        solve();
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        pictures = new boolean[Y][X];

        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int x = 0; x < X; x++) {
                pictures[y][x] = st.nextToken().equals("0");
            }
        }

        br.close();
    }

    private static void solve() {
        int count = 0;
        int maxSize = 0;

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                int size = dfs(y, x);
                if (size == 0) {
                    continue;
                }

                count++;
                maxSize = Integer.max(maxSize, size);
            }
        }

        System.out.println(count);
        System.out.print(maxSize);
    }

    private static int dfs(int y, int x) {
        if (pictures[y][x] == VISITED) {
            return 0;
        }

        pictures[y][x] = VISITED;

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
