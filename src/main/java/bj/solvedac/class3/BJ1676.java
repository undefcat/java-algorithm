package bj.solvedac.class3;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ1676 {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        BigInteger n = BigInteger.ONE;
        for (long i = 2; i <= N; i++) {
            n = n.multiply(BigInteger.valueOf(i));
        }

        String s = n.toString();

        int count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                break;
            }

            count++;
        }

        System.out.println(count);

        sc.close();
    }
}
