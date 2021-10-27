package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ5525 {
    private static final int I = 'I';
    private static final int O = 'O';
    private static final int[] next = {I, O};

    public static void main(String[] args) throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final int SIZE = Integer.parseInt(br.readLine()) * 2 + 1;
        final int LENGTH = Integer.parseInt(br.readLine());

        int ans = 0;
        int size = 0;
        int cur = 0;

        for (int i = 0; i < LENGTH; i++) {
            final int read = br.read();

            if (next[cur % 2] == read) {
                size++;
                cur++;
            } else if (read == I) {
                size = 1;
                cur = 1;
            } else {
                size = 0;
                cur = 0;
            }

            if (size == SIZE) {
                ans++;
                size -= 2;
            }
        }

        System.out.println(ans);

        br.close();
    }
}
