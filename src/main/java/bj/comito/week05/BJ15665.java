package bj.comito.week05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BJ15665 {
    private static int N;
    private static int M;
    private static int[] numbers;
    private static int[] picked;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<10
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        numbers = IntStream.of(numbers).distinct().sorted().toArray();
        N = numbers.length;

        picked = new int[M];

        pick(0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void pick(int idx) throws Throwable {
        if (idx == M) {
            write();
            return;
        }

        for (int i = 0; i < N; i++) {
            picked[idx] = numbers[i];
            pick(idx+1);
        }
    }

    private static void write() throws Throwable {
        for (int n: picked) {
            bw.write(Integer.toString(n));
            bw.write(' ');
        }

        bw.write('\n');
    }
}
