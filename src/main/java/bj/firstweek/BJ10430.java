package bj.firstweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10430 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line, " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int first = (A+B) % C;
        int second = (A*B) % C;

        System.out.println(first);
        System.out.println(first);
        System.out.println(second);
        System.out.println(second);
    }
}
