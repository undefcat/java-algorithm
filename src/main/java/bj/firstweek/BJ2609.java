package bj.firstweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2609 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a < b) {
            int tmp = a;

            a = b;
            b = tmp;
        }

        int gcd = getGcd(a, b);
        int lcm = getLcm(a, b, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int getGcd(int a, int b) {
        while (true) {
            int mod = a%b;
            if (mod == 0) {
                return b;
            }

            a = b;
            b = mod;
        }
    }

    private static int getLcm(int a, int b, int gcd) {
        return (a*b) / gcd;
    }
}
