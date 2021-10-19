package bj.comito.codeplus.basic.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14002 {
    private static int N;
    private static int[] sequence;

    public static void main(String[] args) throws Throwable {
        input();

        System.out.println(dp());
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<15
        );

        N = Integer.parseInt(br.readLine());
        sequence = new int[N];

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int ni = 0; ni < N; ni++) {
            sequence[ni] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    private static String dp() {
        final int[] nextIndex = new int[N];
        final int[] length = new int[N];

        Arrays.fill(nextIndex, -1);
        Arrays.fill(length, 1);

        int maxLength = 0;
        int maxIndex = 0;

        for (int ni = N-1; ni >= 0; ni--) {
            for (int nj = ni; nj < N; nj++) {
                if (sequence[nj] > sequence[ni]) {
                    final int candi = length[nj] + 1;

                    if (length[ni] < candi) {
                        length[ni] = candi;
                        nextIndex[ni] = nj;
                    }
                }
            }

            if (length[ni] > maxLength) {
                maxLength = length[ni];
                maxIndex = ni;
            }
        }

        final StringBuilder sb = new StringBuilder(1000*1000);

        sb.append(maxLength);
        sb.append('\n');

        int startIndex = maxIndex;
        while (startIndex >= 0) {
            sb.append(sequence[startIndex]);
            sb.append(' ');
            startIndex = nextIndex[startIndex];
        }

        return sb.toString();
    }
}
