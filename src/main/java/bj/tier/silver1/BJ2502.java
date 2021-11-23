package bj.tier.silver1;

import java.util.Scanner;

public class BJ2502 {
    private static final int[] A = {
            0, 0, 0,
            1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
            89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,
            10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040,
            1346269, 2178309,
    };

    private static final int[] B = {
            0, 0,
            1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
            89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,
            10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040,
            1346269, 2178309,
    };

    private static int D;
    private static int K;

    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        D = sc.nextInt();
        K = sc.nextInt();

        sc.close();

        for (int b = 1; b <= 100_000; b++) {
            if (isCandi(b)) {
                final int a = getA(b);

                if (isAnswer(a, b)) {
                    System.out.println(a);
                    System.out.println(b);
                    return;
                }
            }
        }

        throw new RuntimeException();
    }

    private static boolean isCandi(final int b) {
        return (K - (B[D] * b)) % A[D] == 0;
    }

    private static int getA(final int b) {
        return (K - (B[D] * b)) / A[D];
    }

    private static boolean isAnswer(final int a, final int b) {
        return a < b && ((A[D] * a) + (B[D] * b) == K);
    }
}
