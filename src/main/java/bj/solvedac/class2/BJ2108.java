package bj.solvedac.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BJ2108 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<16
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<10
    );

    public static void main(String[] args) throws Throwable {
        final int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            int number = Integer.parseInt(br.readLine());

            write(number);
            write(number);
            write(number);
            write(0);

            bw.flush();
            bw.close();
            br.close();

            return;
        }

        final int[] numbers = new int[N];

        int sum = 0;
        for (int ni = 0; ni < N; ni++) {
            int number = Integer.parseInt(br.readLine());

            numbers[ni] = number;
            sum += number;
        }

        // 1. 산술평균
        write(Math.round((float)sum / (float)N));

        Arrays.sort(numbers);

        // 2. 중앙값
        write(numbers[N/2]);

        // 3. 최빈값
        List<Number> list = new ArrayList<>(N);

        list.add(new Number(numbers[0]));

        Number before = list.get(0);
        for (int ni = 1; ni < N; ni++) {
            if (numbers[ni] == before.number) {
                before.count++;
                continue;
            }

            Number newNumber = new Number(numbers[ni]);
            list.add(newNumber);

            before = newNumber;
        }

        list.sort((a, b) -> {
            if (a.count == b.count) {
                return a.number - b.number;
            }

            return b.count - a.count;
        });

        Number first = list.get(0);
        Number second = list.get(1);

        if (first.count == second.count) {
            write(second.number);
        } else {
            write(first.number);
        }

        // 4. 범위
        write(numbers[N-1] - numbers[0]);

        bw.flush();
        bw.close();
        br.close();
    }

    static class Number {
        public final int number;
        public int count = 1;

        public Number(int number) {
            this.number = number;
        }
    }

    private static void write(int number) throws Throwable {
        bw.write(Integer.toString(number));
        bw.write('\n');
    }
}
