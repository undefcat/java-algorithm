package bj.comito.codeplus.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ6064_1 {
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

            final int ans = solve(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );

            bw.write(Integer.toString(ans));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 중국인의 나머지 정리를 이용하면 풀 수 있다는데...
    // 그런 이론적인 내용은 나중에 기회가 되면 해결해보고...
    // brute force로 풀어보자...
    private static int solve(int M, int N, int x, int y) {
        // 가지치기

        // 1. x와 y가 같은 경우
        // 그냥 똑같이 올라가면 된다.
        if (x == y) {
            return x;
        }

        // M < N으로 고정해서 문제를 풀고
        // M > N이라면 M < N으로 바꾸고
        // x, y의 위치도 바꾼다.
        // 그래도 정답은 같을 것이다.
        if (M > N) {
            int tmp = M;
            M = N;
            N = tmp;

            tmp = x;
            x = y;
            y = tmp;
        }

        // 최대 년도를 계산하는 방법이 있긴 있을 것이지만
        // 난 모른다...
        final int maxYear = M * N;

        int xx = x;
        int yy = x;
        int year = x;

        while (year <= maxYear) {
            if (yy == y) {
                return year;
            }

            year += M;

            yy += M;

            if (yy > N) {
                yy -= N;
            }
        }

        return -1;
    }
}
