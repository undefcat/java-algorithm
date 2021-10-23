package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BJ1764 {
    public static void main(String[] args) throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out), 1<<20
        );

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        final Map<String, Boolean> map = new HashMap<>(Math.max(N, M) + 1);

        for (int ni = 0; ni < N; ni++) {
            map.put(br.readLine(), true);
        }

        final List<String> list = new ArrayList<>(Math.max(N, M) +1);
        int count = 0;

        for (int mi = 0; mi < M; mi++) {
            final String name = br.readLine();
            if (!map.containsKey(name)) {
                continue;
            }

            count++;
            list.add(name);
        }

        Collections.sort(list);

        bw.write(Integer.toString(count));
        bw.write('\n');

        for (String name: list) {
            bw.write(name);
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
