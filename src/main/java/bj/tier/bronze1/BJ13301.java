package bj.tier.bronze1;

import java.util.Scanner;

public class BJ13301 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();

        sc.close();

        final long[] fibo = new long[82];

        fibo[1] = 1;
        fibo[2] = 1;

        for (int n = 3; n <= 81; n++) {
            fibo[n] = fibo[n-2] + fibo[n-1];
        }

        System.out.println(2*fibo[N] + 2*fibo[N+1]);
    }
}
