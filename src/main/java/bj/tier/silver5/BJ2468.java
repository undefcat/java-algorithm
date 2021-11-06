package bj.tier.silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2468 {
    private static int N;
    private static int[][] area;
    private static boolean[][] visited;
    private static int minRain = Integer.MAX_VALUE;
    private static int maxRain = Integer.MIN_VALUE;

    private static final int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
    };

    public static void main(String[] args) throws Throwable {
        init();

        int ans = 1;

        for (int rain = minRain; rain <= maxRain; rain++) {
            int countOfArea = 1;
            for (boolean[] v: visited) {
                Arrays.fill(v, false);
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (dfs(y, x, rain)) {
                        countOfArea++;
                    }
                }
            }

            ans = Math.max(ans, countOfArea);
        }

        System.out.println(ans);
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        N = Integer.parseInt(br.readLine());

        area = new int[N][N];
        visited = new boolean[N][N];

        for (int y = 0; y < N; y++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int x = 0; x < N; x++) {
                area[y][x] = Integer.parseInt(st.nextToken());
                minRain = Math.min(minRain, area[y][x]);
                maxRain = Math.max(maxRain, area[y][x]);
            }
        }

        br.close();
    }

    private static boolean dfs(int y, int x, int rain) {
        if (!canVisit(y, x, rain)) {
            return false;
        }

        visited[y][x] = true;

        for (int[] dir: dirs) {
            final int nextY = y + dir[0];
            final int nextX = x + dir[1];

            if (isOutOfIndex(nextY, nextX)) {
                continue;
            }

            dfs(nextY, nextX, rain);
        }

        return true;
    }

    private static boolean canVisit(int y, int x, int rain) {
        return area[y][x] > rain && !visited[y][x];
    }

    private static boolean isOutOfIndex(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }
}
