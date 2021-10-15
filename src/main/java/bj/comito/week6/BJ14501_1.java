package bj.comito.week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501_1 {
    private static int N;

    /**
     * n일 상담이 끝나는 날
     */
    private static int[] endDays;

    /**
     * n일 상담의 상담비
     */
    private static int[] prices;

    /**
     * n일에 상담을 받았을 때, 얻을 수 있는 최대 수익
     */
    private static int[] ans;

    public static void main(String[] args) throws Throwable {
        input();

        System.out.println(dp());
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        N = Integer.parseInt(br.readLine());

        endDays = new int[N+1];
        prices = new int[N+1];
        ans = new int[N+1];

        for (int ni = 1; ni <= N; ni++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int duration = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            endDays[ni] = ni + duration - 1;
            prices[ni] = price;
            ans[ni] = price;
        }

        br.close();
    }

    private static int dp() {
        // 은퇴일
        final int resignation = N+1;
        int ret = 0;

        /**
         * day일에 상담을 받았을 때, 얻을 수 있는 최대 이윤을 계산한다.
         * 이는 at일에 상담을 받았을 때 얻을 수 있는 최대 이윤에 오늘 상담비를 합치면 된다.
         */
        for (int day = 2; day <= N; day++) {
            for (int at = 1; at < day; at++) {
                // at일에 상담을 받아서 오늘 못받는 경우
                if (endDays[at] >= day) {
                    continue;
                }

                ans[day] = Math.max(ans[day], prices[day] + ans[at]);
            }

            // 오늘 상담을 받았는데, 은퇴날 이전에 끝나면
            // 답 후보군으로 넣는다.
            if (endDays[day] < resignation) {
                ret = Math.max(ret, ans[day]);
            }
        }

        return ret;
    }
}
