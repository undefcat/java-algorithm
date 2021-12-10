package bj.tier.silver1;

import java.util.Scanner;

public class BJ16198 {
    private static int N;
    private static int[] marbles;
    private static boolean[] used;
    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws Throwable {
        init();
        solve(N-2, 0);

        System.out.println(ans);
    }

    private static void init() throws Throwable {
        final Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        marbles = new int[N];
        used = new boolean[N];

        for (int n = 0; n < N; n++) {
            marbles[n] = sc.nextInt();
        }

        sc.close();
    }

    private static void solve(int remain, int sum) {
        if (remain == 0) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 1; i < N-1; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;

            final int energy = getEnergy(i);

            solve(remain-1, sum + energy);

            used[i] = false;
        }
    }

    private static int getEnergy(int i) {
        int l, r;

        for (l = i-1; l >= 0; l--) {
            if (!used[l]) {
                break;
            }
        }

        for (r = i+1; r < N; r++) {
            if (!used[r]) {
                break;
            }
        }

        return marbles[l] * marbles[r];
    }
}
