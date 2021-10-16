package bj.comito.codeplus.basic.week06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

public class BJ11723_1 {
    private static final String ADD = "add";
    private static final String REMOVE = "remove";
    private static final String CHECK = "check";
    private static final String TOGGLE = "toggle";
    private static final String ALL = "all";
    private static final String EMPTY = "empty";

    public static void main(String[] args) throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        final BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out)
        );

        final BitSet bitSet = new BitSet();
        final int M = Integer.parseInt(br.readLine());

        for (int mi = 0; mi < M; mi++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            final String operator = st.nextToken();

            switch (operator) {
                case ALL:
                    bitSet.set(1, 20);
                    continue;

                case EMPTY:
                    bitSet.clear();
                    continue;
            }

            final int value = Integer.parseInt(st.nextToken());

            switch (operator) {
                case ADD:
                    bitSet.set(value);
                    continue;

                case REMOVE:
                    bitSet.clear(value);
                    continue;

                case CHECK:
                    if (bitSet.get(value)) {
                        bw.write(Integer.toString(1));
                    } else {
                        bw.write(Integer.toString(0));
                    }

                    bw.write('\n');

                    continue;

                case TOGGLE:
                    bitSet.flip(value);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
