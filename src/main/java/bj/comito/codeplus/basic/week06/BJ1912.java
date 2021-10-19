package bj.comito.codeplus.basic.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1912 {
    private static int[] sequence;

    public static void main(String[] args) throws Throwable {
        init();

        System.out.println(dp());
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 6 * 111_111
        );

        final int N = Integer.parseInt(br.readLine());
        sequence = new int[N];

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int ni = 0; ni < N; ni++) {
            sequence[ni] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    private static int dp() {
        int ans = Integer.MIN_VALUE;
        int intermediateSum = 0;

        for (int num: sequence) {
            intermediateSum = Math.max(intermediateSum + num, num);
            ans = Math.max(ans, intermediateSum);
        }

        return ans;
    }
}
