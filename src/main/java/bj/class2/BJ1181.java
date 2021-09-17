package bj.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1181 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        int n = Integer.parseInt(br.readLine());

        String[] strings = new String[n];

        for (int ni = 0; ni < n; ni++) {
            strings[ni] = br.readLine();
        }

        Arrays.sort(strings, (a, b) -> {
            int diff = a.length() - b.length();

            if (diff != 0) {
                return diff;
            }

            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();

        sb.append(strings[0]);
        sb.append('\n');
        for (int ni = 1; ni < n; ni++) {
            if (strings[ni-1].equals(strings[ni])) {
                continue;
            }

            sb.append(strings[ni]);
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
