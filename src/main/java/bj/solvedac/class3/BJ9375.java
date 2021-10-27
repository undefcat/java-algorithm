package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ9375 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<10
    );

    private static StringBuilder sb = new StringBuilder(100_000);

    private static Map<String, Integer> map = new HashMap<>(30);

    public static void main(String[] args) throws Throwable {
        final int T = Integer.parseInt(br.readLine());

        for (int ti = 0; ti < T; ti++) {
            map.clear();

            solve();
        }

        System.out.print(sb);

        br.close();
    }

    private static void solve() throws Throwable {
        final int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            sb.append("0\n");
            return;
        }

        for (int ni = 0; ni < N; ni++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 의상 이름은 중복되는 것이 없으므로
            // 버린다.
            st.nextToken();

            final String type = st.nextToken();

            int current = map.getOrDefault(type, 0);

            map.put(type, current + 1);
        }

        int ans = 1;
        for (int n: map.values()) {
            ans *= (n + 1);
        }

        sb.append(ans - 1);
        sb.append('\n');
    }
}
