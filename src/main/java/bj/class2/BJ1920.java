package bj.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final StringBuilder sb = new StringBuilder(200_001);

    // Map을 이용하면 쉽게 할 수 있을 것 같지만
    // 이분탐색을 연습하자
    public static void main(String[] args) throws Throwable {
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] numbers = new int[N];
        for (int n = 0 ; n < N; n++){
            numbers[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int m = 0; m < M; m++) {
            int target = Integer.parseInt(st.nextToken());

            sb.append(search(numbers, target));
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static int search(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (numbers[mid] < target) {
                left = mid + 1;
            } else if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
