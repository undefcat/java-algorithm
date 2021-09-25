package bj.thirdweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ10972 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Queue<Integer> pq = new PriorityQueue<>(N+1);

        // 순열의 역순으로 들어간다.
        // 1, 2, 3, 4의 경우
        // {4, 3, 2, 1} 로 들어가있다.
        int[] picked = new int[N];
        for (int n = N-1; n >= 0; n--) {
            picked[n] = Integer.parseInt(st.nextToken());
        }

        // 순열의 맨 뒤의 수를 넣는다.
        pq.add(picked[0]);
        int cur;
        for (cur = 1; cur < N; cur++) {
            int next = pq.peek();

            if (picked[cur] < next) {
                int tmp = picked[cur];
                picked[cur] = pq.remove();
                pq.add(tmp);
                cur--;

                break;
            }

            pq.add(picked[cur]);
        }

        if (cur == N) {
            System.out.println(-1);
            return;
        }

        while (cur >= 0) {
            picked[cur] = pq.remove();
            cur--;
        }

        StringBuilder sb = new StringBuilder(22_222);
        for (int i = picked.length-1; i >= 0; i--) {
            sb.append(picked[i]);
            sb.append(' ');
        }

        System.out.println(sb);
    }
}
