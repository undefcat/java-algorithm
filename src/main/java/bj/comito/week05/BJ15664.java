package bj.comito.week05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15664 {
    private static int N;
    private static int M;

    private static int[] numbers;
    private static int[] picked;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<16
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        picked = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int ni = 0; ni < N; ni++) {
            numbers[ni] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        pick(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void pick(int pickIndex, int start) throws Throwable {
        if (pickIndex == M) {
            write();
            return;
        }

        picked[pickIndex] = 0;
        for (int i = start; i < N; i++) {
            int number = numbers[i];

            if (picked[pickIndex] == number) {
                continue;
            }

            picked[pickIndex] = number;

            pick(pickIndex+1, i+1);
        }
    }

    private static void write() throws Throwable {
        for (int number: picked) {
            bw.write(Integer.toString(number));
            bw.write(' ');
        }

        bw.write('\n');
    }
}
