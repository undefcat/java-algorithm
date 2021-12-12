package bj.tier.bronze1;

import java.util.Scanner;

public class BJ15881 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        sc.nextInt();

        final byte[] ppap = sc.next().getBytes();
        final byte[] order = {'p', 'P', 'A', 'p'};

        int ans = 0;
        int next = 0;
        for (byte b: ppap) {
            if (b != order[next]) {
                next = 0;

                if (b == 'p') {
                    next = 1;
                }

                continue;
            }

            next = (next+1) % 4;
            if (next == 0) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
