package bj.tier.silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2531 {
    private static int N; // 접시의 수
    private static int D; // 초밥의 가짓수
    private static int K; // 연속해서 먹는 접시의 수
    private static int C; // 쿠폰 번호

    private static int ans = 0;

    private static final Deque<Integer> deq = new LinkedList<>();
    private static final Deque<Integer> cur = new LinkedList<>();
    private static final Map<Integer, Integer> map = new HashMap<>(3001);

    public static void main(String[] args) throws Throwable {
        init();
        solve();
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int n = 0; n < N; n++) {
            deq.offer(Integer.parseInt(br.readLine()));
        }

        inc(C);

        for (int k = 0; k < K; k++) {
            int sushi = deq.poll();
            deq.offer(sushi);

            cur.offer(sushi);
            inc(sushi);
        }

        br.close();
    }

    private static void solve() {
        ans = map.size();

        for (int n = 0; n < N; n++) {
            step();
        }

        System.out.println(ans);
    }

    private static void step() {
        final int sushi = deq.poll();
        deq.offer(sushi);

        inc(sushi);

        final int removed = cur.poll();
        dec(removed);
        cur.offer(sushi);

        ans = Math.max(ans, map.size());
    }

    private static void inc(int key) {
        int current = map.getOrDefault(key, 0);
        map.put(key, current + 1);
    }

    private static void dec(int key) {
        int current = map.get(key);
        if (current == 1) {
            map.remove(key);
        } else {
            map.put(key, current - 1);
        }
    }
}
