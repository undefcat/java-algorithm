package bj.secondweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9613 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final StringBuilder sb = new StringBuilder(100_000);

    public static void main(String[] args) throws Throwable {
        int t = Integer.parseInt(br.readLine());
        
        int[] nums = new int[101];

        for (int ti = 0; ti < t; ti++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            for (int ni = 0; ni < n; ni++) {
                nums[ni] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            int endA = n - 1;
            for (int a = 0; a < endA; a++) {
                for (int b = a+1; b < n; b++) {
                    sum += gcd(nums[a], nums[b]);
                }
            }

            sb.append(sum);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;

            a = b;
            b = tmp;
        }

        while (true) {
            int r = a % b;
            if (r == 0) {
                return b;
            }

            a = b;
            b = r;
        }
    }
}
