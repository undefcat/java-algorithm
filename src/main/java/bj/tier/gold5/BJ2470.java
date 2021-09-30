package bj.tier.gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2470 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        final int N = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int[] numbers = new int[N];

        for (int ni = 0; ni < N; ni++) {
            numbers[ni] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int l = 0;
        int r = N-1;

        int min = Integer.MAX_VALUE;
        int candiA = l;
        int candiB = r;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            int abs = Math.abs(sum);

            if (abs == 0) {
                System.out.printf("%d %d", numbers[l], numbers[r]);
                return;
            }

            if (abs < min) {
                min = abs;

                candiA = numbers[l];
                candiB = numbers[r];
            }

            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.printf("%d %d", candiA, candiB);
    }
}
