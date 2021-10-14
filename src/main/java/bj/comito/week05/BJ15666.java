package bj.comito.week05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BJ15666 {
    private static int N;
    private static int M;
    private static int[] numbers;
    private static int[] picked;

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        input();
        pick(0, 0);

        bw.flush();
        bw.close();
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        picked = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int ni = 0; ni < N; ni++) {
            numbers[ni] = Integer.parseInt(st.nextToken());
        }

        numbers = IntStream.of(numbers).distinct().sorted().toArray();
        N = numbers.length;

        br.close();
    }

    private static void pick(int currentPickIdx, int startNumberIdx) throws Throwable {
        if (currentPickIdx == M) {
            write();
            return;
        }

        for (int i = startNumberIdx; i < N; i++) {
            picked[currentPickIdx] = numbers[i];
            pick(currentPickIdx + 1, i);
        }
    }

    private static void write() throws Throwable {
        for (int p: picked) {
            bw.write(Integer.toString(p));
            bw.write(' ');
        }

        bw.write('\n');
    }
}
