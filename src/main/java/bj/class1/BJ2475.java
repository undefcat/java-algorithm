package bj.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2475 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int result = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            result += num*num;
        }

        System.out.print(result % 10);
    }
}
