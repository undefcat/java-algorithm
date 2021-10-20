package bj.comito.codeplus.basic.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11054 {
    private static int N;
    private static int[] sequence;
    private static int[] maxEndIncrease;
    private static int[] maxStartDecrease;

    public static void main(String[] args) throws Throwable {
        init();

        calcMaxEndIncrease();
        calcMaxStartDecrease();

        System.out.println(solve());
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 5 * 1111
        );

        N = Integer.parseInt(br.readLine());

        sequence = new int[N];
        maxEndIncrease = new int[N];
        maxStartDecrease = new int[N];

        Arrays.fill(maxStartDecrease, Integer.MIN_VALUE);

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int ni = 0; ni < N; ni++) {
            sequence[ni] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    private static void calcMaxEndIncrease() {
        for (int right = 0; right < N; right++) {
            int candi = 1;

            for (int left = 0; left < right; left++) {
                if (sequence[left] < sequence[right]) {
                    candi = Math.max(candi, maxEndIncrease[left] + 1);
                }
            }

            maxEndIncrease[right] = candi;
        }
    }

    private static void calcMaxStartDecrease() {
        for (int left = N-1; left >= 0; left--) {
            int candi = 1;

            for (int right = left; right < N; right++) {
                if (sequence[right] < sequence[left]) {
                    candi = Math.max(candi, maxStartDecrease[right] + 1);
                }
            }

            maxStartDecrease[left] = candi;
        }
    }

    private static int solve() {
        int ans = 1;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, maxEndIncrease[i] + maxStartDecrease[i] - 1);
        }

        return ans;
    }
}
