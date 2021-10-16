package bj.comito.codeplus.basic.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15658 {
    private static final int ADD = 0;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 3;

    private static int N;
    private static int[] numbers;
    private static boolean[] isUsed;
    private static int[] operators;

    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Throwable {
        input();

        pick(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        N = Integer.parseInt(br.readLine());

        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int ni = 0; ni < N; ni++) {
            numbers[ni] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        final int[] opers = new int[4];
        int operLength = 0;
        for (int oi = 0; oi < 4; oi++) {
            opers[oi] = Integer.parseInt(st.nextToken());
            operLength += opers[oi];
        }

        operators = new int[operLength];
        isUsed = new boolean[operLength];

        int from = 0;
        for (int oi = 0; oi < 4; oi++) {
            int to = from + opers[oi];

            Arrays.fill(operators, from, to, oi);

            from = to;
        }

        br.close();
    }

    private static void pick(int result, int numberIndex) {
        if (numberIndex == N) {
            min = Math.min(min, result);
            max = Math.max(max, result);

            return;
        }

        int beforeUsedOperator = -1;
        for (int oi = 0; oi < operators.length; oi++) {
            if (isUsed[oi]) {
                continue;
            }

            final int currentOperator = operators[oi];
            if (currentOperator == beforeUsedOperator) {
                continue;
            }

            beforeUsedOperator = currentOperator;
            isUsed[oi] = true;

            switch (currentOperator) {
                case ADD:
                    pick(result + numbers[numberIndex], numberIndex+1);
                    break;

                case SUB:
                    pick(result - numbers[numberIndex], numberIndex+1);
                    break;

                case MUL:
                    pick(result * numbers[numberIndex], numberIndex+1);
                    break;

                case DIV:
                    pick(result / numbers[numberIndex], numberIndex+1);
                    break;

                default:
                    throw new RuntimeException("UNREACHABLE CODE");
            }

            isUsed[oi] = false;
        }
    }
}
