package firstweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1476 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1;
        int s = 1;
        int m = 1;

        for (int year = 1; year <= 7980; year++) {
            if (e == E && s == S && m == M) {
                System.out.println(year);
                return;
            }

            e++; s++; m++;

            if (e > 15) {
                e = 1;
            }

            if (s > 28) {
                s = 1;
            }

            if (m > 19) {
                m = 1;
            }
        }
    }
}
