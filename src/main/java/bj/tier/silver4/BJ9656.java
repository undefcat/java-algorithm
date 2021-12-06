package bj.tier.silver4;

import java.util.Scanner;

public class BJ9656 {
    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        if (N%2 == 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

        sc.close();
    }
}
