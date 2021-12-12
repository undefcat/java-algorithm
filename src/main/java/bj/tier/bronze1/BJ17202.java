package bj.tier.bronze1;

import java.util.Scanner;

public class BJ17202 {
    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        final byte[] A = sc.next().getBytes();
        final byte[] B = sc.next().getBytes();

        final int[] nums = new int[16];

        for (int i = 0; i < 8; i++) {
            nums[i*2] = A[i] - '0';
            nums[i*2+1] = B[i] - '0';
        }

        for (int end = 15; end >= 2; end--) {
            for (int i = 0; i < end; i++) {
                nums[i] = nums[i] + nums[i+1];
            }
        }

        System.out.printf("%d%d", nums[0]%10, nums[1]%10);
    }
}
