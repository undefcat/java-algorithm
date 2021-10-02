package bj.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int ni = 0; ni < N; ni++) {
            trees[ni] = Integer.parseInt(st.nextToken());

            max = Math.max(max, trees[ni]);
        }

        long l = 0;
        long r = max;
        long ans = Long.MIN_VALUE;

        Arrays.sort(trees);

        while (l <= r) {
            // 나무의 길이 최댓값이 20억이므로
            // int로하면 안됨
            long h = (l + r) / 2;

            long sum = cut(trees, h);

            // 나무를 잘랐는데 목표보다 넘치면
            // 우선 해당 값이 후보가 된다.
            if (sum >= M) {
                // 최대 h의 길이를 찾는다.
                ans = Math.max(ans, h);
                l = h+1;
            } else {
                r = h-1;
            }
        }

        System.out.println(ans);
    }

    private static long cut(int[] trees, long h) {
        long sum = 0;
        for (int tree: trees) {
            sum += Math.max(0, tree - h);
        }

        return sum;
    }
}
