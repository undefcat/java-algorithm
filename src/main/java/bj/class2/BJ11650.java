package bj.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11650 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<16
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        final int N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N];

        for (int ni = 0; ni < N; ni++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            final int x = Integer.parseInt(st.nextToken());
            final int y = Integer.parseInt(st.nextToken());

            points[ni] = new Point(x, y);
        }

        Arrays.sort(points);

        for (Point p: points) {
            bw.write(Integer.toString(p.x));
            bw.write(' ');
            bw.write(Integer.toString(p.y));
            bw.write('\n');
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static class Point implements Comparable<Point> {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }

            return this.x - o.x;
        }
    }
}
