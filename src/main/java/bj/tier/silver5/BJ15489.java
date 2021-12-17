package bj.tier.silver5;

import java.util.Scanner;

public class BJ15489 {
    public static void main(String[] args) throws Throwable {
        final int[][] triangle = new int[32][32];

        for (int y = 1; y <= 30; y++) {
            triangle[y][1] = 1;

            for (int x = 2; x < y; x++) {
                triangle[y][x] = triangle[y-1][x-1] + triangle[y-1][x];
            }

            triangle[y][y] = 1;
        }

        final Scanner sc = new Scanner(System.in);

        final int R = sc.nextInt();
        final int C = sc.nextInt();
        final int W = sc.nextInt();

        sc.close();

        int sum = 0;
        for (int y = 0; y < W; y++) {
            for (int x = 0; x <= y; x++) {
                sum += triangle[R+y][C+x];
            }
        }

        System.out.println(sum);
    }
}
