package bj.tier.silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2110 {
    private static int N;
    private static int C;

    private static int[] houses;

    public static void main(String[] args) throws Throwable {
        init();

        System.out.println(solve());
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];
        for (int n = 0; n < N; n++) {
            houses[n] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        br.close();
    }

    private static int solve() {
        double l = 0;
        double r = houses[N-1] - houses[0];

        double gap = 0.0;
        for (int i = 0; i < 64; i++) {
            gap = (l + r) / 2;

            if (canInstalledGap(gap)) {
                l = gap;
            } else {
                r = gap;
            }
        }

        return (int)Math.round(gap);
    }

    private static boolean canInstalledGap(double gap) {
        double limit = -1.0;
        int installed = 0;

        for (int position: houses) {
            if (limit <= position) {
                installed++;
                limit = position + gap;
            }
        }

        return installed >= C;
    }
}
