package bj.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ15829 {
    private static final BigInteger R = BigInteger.valueOf(31);
    private static final BigInteger MOD = BigInteger.valueOf(1_234_567_891);

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<10
    );

    public static void main(String[] args) throws Throwable {
        BigInteger sum = BigInteger.ZERO;

        br.readLine();

        final byte delta = 'a' - 1;
        final byte[] chars = br.readLine().getBytes();

        for (int i = 0; i < chars.length; i++) {
            BigInteger value = BigInteger.valueOf((long)(chars[i] - delta));
            value = value.multiply(R.pow(i));

            sum = sum.add(value).mod(MOD);
        }

        System.out.println(sum.toString());
    }
}
