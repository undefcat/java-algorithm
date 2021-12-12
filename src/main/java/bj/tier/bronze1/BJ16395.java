package bj.tier.bronze1;

import java.util.Scanner;

public class BJ16395 {
    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final int K = sc.nextInt();

        sc.close();

        final int[][] triangle = new int[31][31];

        triangle[1][1] = 1;

        triangle[2][1] = 1;
        triangle[2][2] = 1;

        for (int n = 3; n <= 30; n++) {
            triangle[n][1] = 1;
            triangle[n][30] = 1;

            for (int k = 2; k <= 29; k++) {
                triangle[n][k] = triangle[n-1][k-1] + triangle[n-1][k];
            }
        }

        System.out.println(triangle[N][K]);
    }
}
