package bj.tier.bronze2;

import java.util.Scanner;

public class BJ15312 {
    private static int[] chars;
    private static int length;

    public static void main(String[] args) throws Throwable {
        init();
        solve();
    }

    private static void init() throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final byte[] A = sc.next().getBytes();
        final byte[] B = sc.next().getBytes();

        sc.close();

        final int[] keyMap = {
                3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1
        };

        length = A.length;

        chars = new int[length*2];

        for (int i = 0; i < length; i++) {
            chars[i*2] = keyMap[A[i] - 'A'];
            chars[i*2+1] = keyMap[B[i] - 'A'];
        }
    }

    private static void solve() {
        int size = length * 2;

        while (size > 2) {
            final int end = size - 1;
            for (int i = 0; i < end; i++) {
                chars[i] = (chars[i] + chars[i+1]) % 10;
            }

            size--;
        }

        System.out.printf("%d%d", chars[0], chars[1]);
    }
}
