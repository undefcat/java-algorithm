package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ5430 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<10
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<10
    );

    public static void main(String[] args) throws Throwable {
        final int T = Integer.parseInt(br.readLine());

        for (int ti = 0; ti < T; ti++) {
            AC.interpret();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class AC {
        private static final Deque<Integer> deque = new ArrayDeque<>(100_001);

        private static boolean isReversed = false;

        public static void interpret() throws Throwable {
            init();

            final byte[] funcs = br.readLine().getBytes();

            // 배열의 갯수는 버린다.
            br.readLine();

            readArray();

            for (byte f: funcs) {
                switch (f) {
                    case 'R':
                        isReversed = !isReversed;
                        continue;

                    case 'D':
                        if (deque.isEmpty()) {
                            bw.write("error\n");
                            return;
                        }

                        get();
                        continue;

                    default:
                        throw new RuntimeException("UNREACHABLE CODE");
                }
            }

            printArray();
        }

        private static void readArray() throws Throwable {
            final byte[] array = br.readLine().getBytes();

            // 빈 배열인 경우
            if (array.length == 2) {
                return;
            }

            int number = 0;
            for (byte b: array) {
                switch (b) {
                    case '[':
                        continue;

                    case ']':
                    case ',':
                        deque.offer(number);
                        number = 0;
                        break;

                    default:
                        final int digit =(int)b - 48;
                        number *= 10;
                        number += digit;
                }
            }
        }

        private static void init() {
            deque.clear();
            isReversed = false;
        }

        private static Integer get() {
            if (isReversed) {
                return deque.pollLast();
            }

            return deque.pollFirst();
        }

        private static void printArray() throws Throwable {
            if (deque.isEmpty()) {
                bw.write("[]\n");
                return;
            }

            bw.write('[');

            while (!deque.isEmpty()) {
                bw.write(Integer.toString(get()));

                if (!deque.isEmpty()) {
                    bw.write(',');
                }
            }

            bw.write("]\n");
        }
    }
}
