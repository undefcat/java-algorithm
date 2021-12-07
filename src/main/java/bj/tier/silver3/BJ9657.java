package bj.tier.silver3;

import java.util.Scanner;

public class BJ9657 {
    private static final boolean[] isWin = new boolean[1_001];

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        isWin[1] = true;
        isWin[3] = true;
        isWin[4] = true;

        for (int n = 5; n <= N; n++) {
            isWin[n] = !isWin[n-1] || !isWin[n-3] || !isWin[n-4];
        }

        if (isWin[N]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

        sc.close();
    }
}
