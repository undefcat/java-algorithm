package bj.tier.silver4;

import java.util.Scanner;

public class BJ8394 {
    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();

        sc.close();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        if (n == 2) {
            System.out.println(2);
            return;
        }

        int a = 1;
        int b = 2;

        for (int i = 3; i <= n; i++) {
            final int tmp = a;
            a = b;
            b += tmp;
            b %= 10;
        }

        System.out.println(b);
    }
}
