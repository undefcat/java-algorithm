package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ17219 {
    public static void main(String[] args) throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<20
        );

        final BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out), 1<<10
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>(N+1);

        for (int ni = 0; ni < N; ni++) {
            st = new StringTokenizer(br.readLine(), " ");

            final String url = st.nextToken();
            final String password = st.nextToken();

            map.put(url, password);
        }

        for (int mi = 0; mi < M; mi++) {
            final String url = br.readLine();

            bw.write(map.get(url));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
