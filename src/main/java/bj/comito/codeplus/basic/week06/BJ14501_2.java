package bj.comito.codeplus.basic.week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501_2 {
    private static int N;

    /**
     * n일 상담이 끝나는 날
     */
    private static int[] endDays;

    /**
     * n일 상담의 상담비
     */
    private static int[] prices;

    public static void main(String[] args) throws Throwable {
        input();

        System.out.println(bruteForce());
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        N = Integer.parseInt(br.readLine());

        endDays = new int[N+1];
        prices = new int[N+1];

        for (int ni = 1; ni <= N; ni++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int duration = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            endDays[ni] = ni + duration - 1;
            prices[ni] = price;
        }

        br.close();
    }

    private static int bruteForce() {
        return solve(1, 0);
    }

    private static int solve(int day, int benefit) {
        // 오늘이 N일을 지나면 퇴사일이다.
        if (day > N) {
            return benefit;
        }

        // 오늘 상담을 받았는데, 퇴사일 이후면
        // 오늘 상담은 못받는다.
        if (endDays[day] > N) {
            return solve(day+1, benefit);
        }

        // 오늘 상담 받았을 때와
        // 오늘 상담 건너 뛰었을 때 중 최댓값
        return Math.max(
                solve(endDays[day] + 1, benefit + prices[day]),
                solve(day + 1, benefit)
        );
    }
}
