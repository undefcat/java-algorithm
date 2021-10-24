package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2630 {
    private static final int[] answer = new int[2];

    private static int N;
    private static byte[][] paper;
    public static void main(String[] args) throws Throwable {
        init();

        splice(N, 0, 0);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        N = Integer.parseInt(br.readLine());

        paper = new byte[N][N];

        for (int y = 0; y < N; y++) {
            final byte[] line = br.readLine().getBytes();

            for (int x = 0; x < N; x++) {
                paper[y][x] = line[x*2];
            }
        }

        br.close();
    }

    private static void splice(int size, int y, int x) {
        if (size == 1) {
            countPaper(y, x);
            return;
        }

        if (isAllSame(size, y, x)) {
            countPaper(y, x);
            return;
        }

        final int cutSize = size / 2;
        final int endY = y + size;
        final int endX = x + size;

        for (int yy = y; yy < endY; yy += cutSize) {
            for (int xx = x; xx < endX; xx += cutSize) {
                splice(cutSize, yy, xx);
            }
        }
    }

    private static void countPaper(int y, int x) {
        switch (paper[y][x]) {
            case '0':
                answer[0]++;
                return;

            case '1':
                answer[1]++;
                return;

            default:
                throw new RuntimeException("UNREACHABLE CODE");
        }
    }

    private static boolean isAllSame(int size, int y, int x) {
        final byte target = paper[y][x];
        final int endY = y + size;
        final int endX = x + size;

        for (int yy = y; yy < endY; yy++) {
            for (int xx = x; xx < endX; xx++) {
                if (paper[yy][xx] != target) {
                    return false;
                }
            }
        }

        return true;
    }
}
