package bj.solvedac.class3;

import java.util.Arrays;
import java.util.Scanner;

public class BJ17626 {
    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        final int[] cache = new int[N+1];
        Arrays.fill(cache, Integer.MAX_VALUE);

        final int sqrtN = (int)Math.sqrt(N);

        // 제곱수의 항의 갯수는 1이다.
        for (int n = 1; n <= sqrtN; n++) {
            cache[n*n] = 1;
        }

        if (cache[N] == 1) {
            System.out.println(1);
            return;
        }

        for (int n = 1; n <= N; n++) {
            if (cache[n] == 1) {
                continue;
            }

            final int sqrt = (int)Math.sqrt(n);
            for (int m = sqrt; m > 0; m--) {
                final int squareM = m*m;

                cache[n] = Math.min(cache[n], 1 + cache[n - squareM]);
            }
        }

        System.out.println(cache[N]);
    }

}
