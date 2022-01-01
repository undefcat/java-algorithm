package bj.tier.silver3;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ14495 {
    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        if (N <= 3) {
            System.out.println(1);
            return;
        }

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ONE;

        for (int n = 4; n <= N; n++) {
            BigInteger newC = a.add(c);
            BigInteger newA = b;

            b = c;
            a = newA;
            c = newC;
        }

        System.out.println(c);
    }
}
