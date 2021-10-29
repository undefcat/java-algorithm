package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ18870 {
    public static void main(String[] args) throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<20
        );

        final BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out), 1<<20
        );

        final int N = Integer.parseInt(br.readLine());

        final int[] sortTargets = new int[N];
        final int[] coordinates = new int[N];

        final Map<Integer, Integer> mapper = new HashMap<>(N+1);

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int ni = 0; ni < N; ni++) {
            final int coordinate = Integer.parseInt(st.nextToken());
            sortTargets[ni] = coordinate;
            coordinates[ni] = coordinate;
        }

        Arrays.sort(sortTargets);

        int to = 0;
        for (int num: sortTargets) {
            if (mapper.containsKey(num)) {
                continue;
            }

            mapper.put(num, to);
            to++;
        }

        for (int num: coordinates) {
            bw.write(Integer.toString(mapper.get(num)));
            bw.write(' ');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
