package bj.tier.silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1010 {
    private static int[][] cache = new int[31][31];

    public static void main(String[] args) throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out), 1<<10
        );

        final int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            final int left = Integer.parseInt(st.nextToken());
            final int right = Integer.parseInt(st.nextToken());

            bw.write(Integer.toString(f(left, right)));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int f(int left, int right) {
        if (cache[left][right] > 0) {
            return cache[left][right];
        }

        if (right < left) {
            return 0;
        }

        if (left == 1) {
            return right;
        }

        System.out.printf("cache[%d][%d]\n", left, right);
        final int l = left - 1;
        for (int r = right-1; r >= l; r--) {
            cache[left][right] += f(l, r);
        }

        return cache[left][right];
    }
}
