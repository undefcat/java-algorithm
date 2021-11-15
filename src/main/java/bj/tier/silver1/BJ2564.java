package bj.tier.silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2564 {
    private static int Y;
    private static int X;
    private static int start;
    private static int[] positions;

    public static void main(String[] args) throws Throwable {
        init();
        System.out.println(solve());
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        final int storeCount = Integer.parseInt(br.readLine());
        positions = new int[storeCount];

        for (int i = 0; i < storeCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            final int dir = Integer.parseInt(st.nextToken());
            final int pos = Integer.parseInt(st.nextToken());

            positions[i] = toLinear(dir, pos);
        }

        st = new StringTokenizer(br.readLine(), " ");

        final int dir = Integer.parseInt(st.nextToken());
        final int pos = Integer.parseInt(st.nextToken());

        start = toLinear(dir, pos);

        br.close();
    }

    private static int toLinear(int dir, int pos) {
        switch (dir) {
            case 1:
                return pos;

            case 2:
                return 2*X + Y - pos;

            case 3:
                return 2*X + 2*Y - pos;

            case 4:
                return X + pos;
        }

        throw new RuntimeException("UNREACHABLE CODE");
    }

    private static int solve() {
        final int totalDist = 2*X + 2*Y;
        int ans = 0;

        for (int pos: positions) {
            final int dist = Math.abs(pos - start);

            ans += Math.min(dist, totalDist - dist);
        }

        return ans;
    }
}
