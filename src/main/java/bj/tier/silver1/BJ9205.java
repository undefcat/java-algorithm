package bj.tier.silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BJ9205 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<10
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<10
    );

    private static final List<Location> list = new ArrayList<>(101);

    private static int Y;
    private static int X;

    public static void main(String[] args) throws Throwable {
        final int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            list.clear();

            if (solve()) {
                bw.write("happy\n");
            } else {
                bw.write("sad\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean solve() throws Throwable {
        final int N = Integer.parseInt(br.readLine());
        final int all = N+2;
        final boolean[][] streets = new boolean[all][all];

        list.add(Location.create());

        for (int n = 0; n < N; n++) {
            list.add(Location.create());
        }

        list.add(Location.create());

        for (int k = 0; k < all; k++) {
            Location lK = list.get(k);

            for (int a = 0; a < all; a++) {
                Location lA = list.get(a);

                for (int b = 0; b < all; b++) {
                    Location lB = list.get(b);

                    final boolean canGo = (streets[a][k] && streets[k][b])
                            || lA.canGo(lB);

                    if (canGo) {
                        streets[a][b] = true;
                    }
                }
            }
        }

        return streets[0][N+1];
    }

    static class Location {
        final int y;
        final int x;

        public static Location create() throws Throwable {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            final int x = Integer.parseInt(st.nextToken());
            final int y = Integer.parseInt(st.nextToken());

            return new Location(y, x);
        }

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public boolean canGo(Location o) {
            final int dist = Math.abs(y - o.y) + Math.abs(x - o.x);

            return dist <= 1000;
        }
    }
}
