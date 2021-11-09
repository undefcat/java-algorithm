package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ10026 {
    private static final byte[] R = {'R'};
    private static final byte[] G = {'G'};
    private static final byte[] B = {'B'};
    private static final byte[] RG = {'R', 'G'};

    private static final int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
    };

    private static int N;
    private static byte[][] zone;
    private static int[][] visited;

    public static void main(String[] args) throws Throwable {
        init();

        System.out.printf("%d %d", dfsNormal(), dfsColorWeakness());
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        N = Integer.parseInt(br.readLine());

        zone = new byte[N][];
        visited = new int[N][N];

        for (int ni = 0; ni < N; ni++) {
            zone[ni] = br.readLine().getBytes();
        }

        br.close();
    }

    private static int dfsNormal() {
        int ans = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (dfs(y, x, getNormalTargets(y, x), 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static int dfsColorWeakness() {
        int ans = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (dfs(y, x, getColorWeaknessTargets(y, x), 2)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static byte[] getNormalTargets(int y, int x) {
        switch (zone[y][x]) {
            case 'R':
                return R;

            case 'G':
                return G;

            default:
                return B;
        }
    }

    private static byte[] getColorWeaknessTargets(int y, int x) {
        switch (zone[y][x]) {
            case 'R':
            case 'G':
                return RG;

            default:
                return B;
        }
    }

    private static boolean dfs(int y, int x, byte[] targets, int visitFlag) {
        if (visited[y][x] == visitFlag) {
            return false;
        }

        visited[y][x] = visitFlag;

        for (int[] dir: dirs) {
            final int nextY = y + dir[0];
            final int nextX = x + dir[1];

            if (isOutOfIndex(nextY, nextX)) {
                continue;
            }

            if (!isTarget(targets, zone[nextY][nextX])) {
                continue;
            }

            dfs(nextY, nextX, targets, visitFlag);
        }

        return true;
    }

    private static boolean isOutOfIndex(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    private static boolean isTarget(byte[] arr, byte needle) {
        for (byte b: arr) {
            if (b == needle) {
                return true;
            }
        }

        return false;
    }
}
