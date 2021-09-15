package bj.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ4153 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder(10_000);

        int[] nums = new int[3];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < 3; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);

            int a = nums[0]*nums[0];
            int b = nums[1]*nums[1];
            int c = nums[2]*nums[2];

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (a + b == c) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}
