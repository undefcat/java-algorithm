package bj.tier.silver1;

import java.util.Scanner;

public class BJ9658 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        final boolean[] isWin = new boolean[1_001];

        isWin[1] = false;
        isWin[2] = true;
        isWin[3] = false;
        isWin[4] = true;
        isWin[5] = true;

        for (int n = 6; n <= N; n++) {
            isWin[n] = !isWin[n-1] || !isWin[n-3] || !isWin[n-4];
        }

        System.out.println(isWin[N] ? "SK" : "CY");

        sc.close();
    }
}
