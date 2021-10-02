package bj.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ4949 {
    private static final Deque<Byte> stack = new ArrayDeque<Byte>(100);

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<16
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }

            bw.write(isValid(line) ? "yes" : "no");
            bw.write('\n');
        }

        bw.flush();
    }

    private static boolean isValid(String line) {
        stack.clear();

        for (byte c: line.getBytes()) {
            switch (c) {
                case '[':
                case '(':
                    stack.push(c);
                    break;

                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }

                    if (stack.remove() != '[') {
                        return false;
                    }

                    break;

                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }

                    if (stack.remove() != '(') {
                        return false;
                    }

                    break;
            }
        }

        // 온전한 괄호라면 스택이 비어있어야 한다.
        return stack.isEmpty();
    }
}
