package bj.tier.silver5;

import java.util.Scanner;

public class BJ14916 {
    private static int MAX = 100_000;

    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        sc.close();

        final int[] coins = new int[100_001];

        coins[1] = MAX;
        coins[2] = 1;
        coins[3] = MAX;
        coins[4] = 2;
        coins[5] = 1;

        for (int n = 6; n <= 100_000; n++) {
            coins[n] = Math.min(coins[n-2], coins[n-5]) + 1;
        }

        final int ans = coins[N] >= MAX ? -1 : coins[N];

        System.out.println(ans);
    }
}
