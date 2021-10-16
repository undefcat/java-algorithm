package bj.comito.codeplus.basic.week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888 {
    private static final int ADD = 0; // +
    private static final int SUB = 1; // -
    private static final int MUL = 2; // *
    private static final int DIV = 3; // /

    private static int[] nums;

    private static int O;
    private static int[] operators;
    private static boolean[] used;

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<10
    );

    public static void main(String[] args) throws Throwable {
        final int N = Integer.parseInt(br.readLine());
        O = N-1;

        nums = new int[N];
        operators = new int[O];
        used = new boolean[O];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int ni = 0; ni < N; ni++) {
            nums[ni] = Integer.parseInt(st.nextToken());
        }

        int oi = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int op = 0; op < 4; op++) {
            int count = Integer.parseInt(st.nextToken());
            for (int i = 0; i < count; i++) {
                operators[oi++] = op;
            }
        }

        pick(nums[0], 0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void pick(int result, int idx) {
        if (idx == O) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for (int i = 0; i < O; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;

            switch (operators[i]) {
                case ADD:
                    pick(result + nums[idx+1], idx+1);
                    break;

                case SUB:
                    pick(result - nums[idx+1], idx+1);
                    break;

                case MUL:
                    pick(result * nums[idx+1], idx+1);
                    break;

                case DIV:
                    pick(result / nums[idx+1], idx+1);
                    break;

                default:
                    throw new RuntimeException("UNREACHABLE CODE");
            }

            used[i] = false;
        }
    }
}
