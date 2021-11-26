package bj.tier.silver5;

import java.util.Scanner;

public class BJ9655 {
    private static final int SK = 1;
    private static final int CY = 2;

    private static final int[] cache = new int[1_001];

    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        if (isSKWin(N)) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }

    private static boolean isSKWin(int n) {
        if (n <= 3) {
            return n != 2;
        }

        if (cache[n] != 0) {
            return cache[n] == SK;
        }

        boolean result = !isSKWin(n-1) || !isSKWin(n-3);

        cache[n] = result ? SK : CY;

        return cache[n] == SK;
    }
}
