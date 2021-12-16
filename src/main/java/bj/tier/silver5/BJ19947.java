package bj.tier.silver5;

import java.util.Scanner;

public class BJ19947 {
    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int H = sc.nextInt();
        final int Y = sc.nextInt();

        final int[] money = new int[16];

        money[0] = H;

        for (int year = 0; year <= 10; year++) {
            money[year+1] = Math.max(money[year+1], (int)(money[year]*1.05));
            money[year+3] = Math.max(money[year+3], (int)(money[year]*1.2));
            money[year+5] = Math.max(money[year+5], (int)(money[year]*1.35));
        }

        System.out.println(money[Y]);
    }
}
