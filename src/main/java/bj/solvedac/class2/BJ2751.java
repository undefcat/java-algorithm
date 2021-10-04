package bj.solvedac.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ2751 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<20
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<20
    );

    public static void main(String[] args) throws Throwable {
        final int N = Integer.parseInt(br.readLine());

        final int[] numbers = new int[N];
        for (int n = 0; n < N; n++) {
            numbers[n] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        for (int num: numbers) {
            bw.write(Integer.toString(num));
            bw.write('\n');
        }

        bw.flush();
    }
}
