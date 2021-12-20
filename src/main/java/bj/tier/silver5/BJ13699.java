package bj.tier.silver5;

import java.util.Scanner;

public class BJ13699 {
    public static void main(String[] args) {
        final long[] t = new long[36];

        t[0] = 1;

        for (int n = 1; n <= 35; n++) {
            for (int i = 0; i <= n-1; i++) {
                t[n] += t[i] * t[n-1-i];
            }
        }

        final Scanner sc = new Scanner(System.in);

        System.out.println(t[sc.nextInt()]);

        sc.close();
    }
}
