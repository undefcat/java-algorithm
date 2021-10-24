package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1780 {
    private static int N;
    private static int[][] paper;
    private static final int[] answer = new int[3];

    public static void main(String[] args) throws Throwable {
        init();

        splice(N, 0, 0);

        for (int i = 0; i < 3; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for (int y = 0; y < N; y++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int x = 0; x < N; x++) {
                paper[y][x] = Integer.parseInt(st.nextToken());
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

        final int cutSize = size / 3;
        final int endY = y + size;
        final int endX = x + size;

        for (int yy = y; yy < endY; yy += cutSize) {
            for (int xx = x; xx < endX; xx += cutSize) {
                splice(cutSize, yy, xx);
            }
        }
    }

    private static boolean isAllSame(int size, int y, int x) {
        final int target = paper[y][x];
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

    private static void countPaper(int y, int x) {
        switch (paper[y][x]) {
            case -1:
                answer[0]++;
                return;

            case 0:
                answer[1]++;
                return;

            case 1:
                answer[2]++;
                return;

            default:
                throw new RuntimeException("UNREACHABLE CODE");
        }
    }
}
