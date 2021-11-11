package bj.tier.silver1;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ1629 {
    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final BigInteger A = sc.nextBigInteger();
        final BigInteger B = sc.nextBigInteger();
        final BigInteger C = sc.nextBigInteger();

        System.out.println(A.modPow(B, C).toString());
    }
}
