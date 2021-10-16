package bj.comito.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2156 {
    private static final int NONE = 0;
    private static final int ONCE = 1;
    private static final int TWICE = 2;

    private static int N;
    private static int[] wines;

    public static void main(String[] args) throws Throwable {
        input();

        System.out.println(dp());
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<15
        );

        N = Integer.parseInt(br.readLine());
        wines = new int[N];

        for (int ni = 0; ni < N; ni++) {
            wines[ni] = Integer.parseInt(br.readLine());
        }

        br.close();
    }

    private static int dp() {
        final int[] none = new int[N];
        final int[] once = new int[N];
        final int[] twice = new int[N];

        none[0] = 0;
        once[0] = wines[0];
        twice[0] = wines[0];

        for (int ni = 1; ni < N; ni++) {
            none[ni] = Math.max(once[ni-1], twice[ni-1]);
            once[ni] = wines[ni] + none[ni-1];
            twice[ni] = wines[ni] + once[ni-1];
        }

        return Math.max(
                none[N-1],
                Math.max(once[N-1], twice[N-1])
        );
    }
}
