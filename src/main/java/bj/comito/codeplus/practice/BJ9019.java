package bj.comito.codeplus.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BJ9019 {
    private static final Deque<State> q = new LinkedList<>();
    private static final Deque<Character> q2 = new LinkedList<>();

    private static final State[] visited = new State[10_000];

    private static final char COMMAND_START = '0';
    private static final char COMMAND_D = 'D';
    private static final char COMMAND_S = 'S';
    private static final char COMMAND_L = 'L';
    private static final char COMMAND_R = 'R';

    public static void main(String[] args) throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out), 1<<10
        );

        final int T = Integer.parseInt(br.readLine());

        for (int ti = 0; ti < T; ti++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            final int start = Integer.parseInt(st.nextToken());
            final int end = Integer.parseInt(st.nextToken());

            bw.write(solve(start, end));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static String solve(int start, int end) {
        q.clear();
        Arrays.fill(visited, null);

        State s = new State(start);
        q.offer(s);
        visited[start] = s;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.number == end) {
                break;
            }

            State next;

            next = cur.D();
            if (next != null) {
                q.offer(next);
                visited[next.number] = next;
            }

            next = cur.S();
            if (next != null) {
                q.offer(next);
                visited[next.number] = next;
            }

            next = cur.L();
            if (next != null) {
                q.offer(next);
                visited[next.number] = next;
            }

            next = cur.R();
            if (next != null) {
                q.offer(next);
                visited[next.number] = next;
            }
        }

        return printCommands(end);
    }

    private static String printCommands(int end) {
        State state = visited[end];

        while (state.beforeCommand != COMMAND_START) {
            q2.push(state.beforeCommand);
            state = visited[state.beforeNumber];
        }

        StringBuilder sb = new StringBuilder(1<<8 + 1);

        while (!q2.isEmpty()) {
            sb.append(q2.pop());
        }

        return sb.toString();
    }

    static class State {
        final int number;
        final char beforeCommand;
        final int beforeNumber;
        final int[] digit;

        public State(int number) {
            this.number = number;
            this.beforeCommand = COMMAND_START;
            this.beforeNumber = -1;
            this.digit = getDigit(number);
        }

        public State(int number, char beforeCommand, int beforeNumber, int[] digit) {
            this.number = number;
            this.beforeCommand = beforeCommand;
            this.beforeNumber = beforeNumber;
            this.digit = digit;
        }

        public State D() {
            final int nextNumber = (2 * number) % 10_000;
            if (visited[nextNumber] != null) {
                return null;
            }

            return new State(nextNumber, COMMAND_D, number, getDigit(nextNumber));
        }

        public State S() {
            final int nextNumber = number == 0
                    ? 9999
                    : number - 1;

            if (visited[nextNumber] != null) {
                return null;
            }

            return new State(nextNumber, COMMAND_S, number, getDigit(nextNumber));
        }

        public State L() {
            final int[] nextDigit = {
                    digit[1], digit[2], digit[3], digit[0],
            };

            final int nextNumber = getNumber(nextDigit);
            if (visited[nextNumber] != null) {
                return null;
            }

            return new State(nextNumber, COMMAND_L, number, nextDigit);
        }

        public State R() {
            final int[] nextDigit = {
                    digit[3], digit[0], digit[1], digit[2],
            };

            final int nextNumber = getNumber(nextDigit);
            if (visited[nextNumber] != null) {
                return null;
            }

            return new State(nextNumber, COMMAND_R, number, nextDigit);
        }

        private static int[] getDigit(int num) {
            final int[] nextDigit = new int[4];
            for (int i = 3; i >= 0; i--) {
                nextDigit[i] = num % 10;
                num /= 10;
            }

            return nextDigit;
        }

        private static int getNumber(int[] digit) {
            int number = 0;

            for (int num: digit) {
                number *= 10;
                number += num;
            }

            return number;
        }
    }
}
