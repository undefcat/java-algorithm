package bj.comito.codeplus.basic.week04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ10974 {
    private static int N;

    private static final boolean[] used = new boolean[9];
    private static final int[] picked = new int[9];

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 20 * 40_320
    );

    public static void main(String[] args) throws Throwable {
        N = Integer.parseInt(br.readLine());

        pick(0);

        bw.flush();
    }

    private static void pick(int index) throws Throwable {
        if (index == N) {
            for (int i = 0; i < N; i++) {
                bw.write(Integer.toString(picked[i]));
                bw.write(' ');
            }

            bw.write('\n');

            return;
        }

        for (int num = 1; num <= N; num++) {
            if (used[num]) {
                continue;
            }

            used[num] = true;
            picked[index] = num;
            pick(index+1);
            used[num] = false;
        }
    }
}
