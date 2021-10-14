package bj.comito.week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1182 {
    private static int N;
    private static int S;

    private static int[] numbers;

    public static void main(String[] args) throws Throwable {
        input();

        System.out.println(pick(0, 0) - 1);
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int ni = 0; ni < N; ni++) {
            numbers[ni] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        br.close();
    }

    private static int pick(int idx, int sum) {
        if (idx == N) {
            if (sum == S) {
                return 1;
            }

            return 0;
        }

        if (numbers[idx] >= 0 && sum > S) {
            return 0;
        }

        int ret = 0;

        ret += pick(idx+1, sum + numbers[idx]);
        ret += pick(idx+1, sum);

        return ret;
    }
}
