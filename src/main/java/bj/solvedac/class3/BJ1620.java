package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1620 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<16
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        final Map<String, String> map = new HashMap<>(N*2 + 1);

        for (int ni = 1; ni <= N; ni++) {
            String name = br.readLine();
            String number = Integer.toString(ni);

            map.put(name, number);
            map.put(number, name);
        }

        for (int mi = 0; mi < M; mi++) {
            bw.write(map.get(br.readLine()));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
