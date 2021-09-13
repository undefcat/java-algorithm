package firstweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2309 {
    private static int[] arr = new int[9];

    private static boolean[] picked = new boolean[9];

    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        comb(0, 7, 0);
    }

    public static void comb(int current, int remain, int sum) {
        if (remain == 0) {
            if (sum == 100) {
                printAnswer();
                System.exit(0);
            }

            return;
        }

        if (sum > 100) {
            return;
        }

        for (int i = current; i < 9; i++) {
            if (picked[i]) {
                continue;
            }

            picked[i] = true;
            comb(i + 1, remain - 1, sum + arr[i]);
            picked[i] = false;
        }
    }

    public static void printAnswer() {
        for (int i = 0; i < 9; i++) {
            if (picked[i]) {
                System.out.println(arr[i]);
            }
        }
    }
}
