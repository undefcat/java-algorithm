package bj.solvedac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1259 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        StringBuilder sb = new StringBuilder(100_000);

        outer:
        while (true) {
            String line = br.readLine();

            if (line.equals("0")) {
                break;
            }

            int length = line.length();
            int end = (length / 2);
            for (int i = 0; i < end; i++) {
                if (line.codePointAt(i) != line.codePointAt(length-1-i)) {
                    sb.append("no\n");
                    continue outer;
                }
            }

            sb.append("yes\n");
        }

        System.out.print(sb);
    }
}
