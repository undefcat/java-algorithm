package bj.tier.bronze1;

import java.util.Scanner;

public class BJ9625 {
    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int K = sc.nextInt();

        final int[] a = new int[46];
        final int[] b = new int[46];

        a[0] = 1;
        b[0] = 0;

        for (int k = 1; k <= 45; k++) {
            a[k] = b[k-1];
            b[k] = a[k-1] + b[k-1];
        }

        System.out.printf("%d %d", a[K], b[K]);
    }
}
