package bj.comito.codeplus.basic.week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ10973 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        PriorityQueue<Integer> pq = new PriorityQueue<>(N, Collections.reverseOrder());
        int min = Integer.MAX_VALUE;

        int[] picked = new int[N];

        for (int n = 0; n < N; n++) {
            picked[n] = Integer.parseInt(st.nextToken());
        }

        // 맨 마지막 순열을 pq에 넣는다.
        pq.add(picked[N-1]);

        // 현재 pq에 있는 수 중 가장 작은 수를 추적한다.
        min = picked[N-1];

        // 마지막 두번째 배열부터 돈다.
        int cur = N-2;
        while (cur >= 0) {
            // 현재 수보다 작은 수가 pq에 있으면
            // 그 이전 순열이 존재하는 것이기 때문에
            // break
            if (picked[cur] > min) {
                pq.add(picked[cur]);
                break;
            }

            pq.add(picked[cur]);
            min = picked[cur];
            cur--;
        }

        // 이 경우엔 순서가 정확히 오름차순으로 정렬되어 있는 경우이므로
        // -1
        if (cur < 0) {
            System.out.println(-1);
            return;
        }

        // pq에 있는 수를 내림차순으로 담을 큐
        Queue<Integer> q = new ArrayDeque<>(pq.size());
        while (true) {
            int value = pq.remove();
            if (value < picked[cur]) {
                picked[cur] = value;
                cur++;
                break;
            }

            q.add(value);
        }

        while (!pq.isEmpty()) {
            q.add(pq.remove());
        }

        while (!q.isEmpty()) {
            picked[cur++] = q.remove();
        }

        StringBuilder sb = new StringBuilder(
                ((10 - 1) * 2) + // 1자리수 + 공백
                        ((100 - 10) * 3) + // 2자리수 + 공백
                        ((1000 - 100) * 4) + // 3자리수 + 공백
                        ((10000 - 1000) * 5) + // 4자리수 + 공백
                        6 + // 5자리수 + 공백
                        100 // 여유분
        );

        for (int i = 0; i < N; i++) {
            sb.append(picked[i]);
            sb.append(' ');
        }

        System.out.println(sb);
    }
}
