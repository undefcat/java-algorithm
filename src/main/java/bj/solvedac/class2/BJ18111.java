package bj.solvedac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18111 {
    private static int minTime = Integer.MAX_VALUE;
    private static int maxHeight = Integer.MIN_VALUE;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int Y = Integer.parseInt(st.nextToken());
        final int X = Integer.parseInt(st.nextToken());

        final int inventory = Integer.parseInt(st.nextToken());

        final int[] heights = new int[X*Y];

        int minH = Integer.MAX_VALUE;
        int mapBlockHeights = 0;
        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine(), " ");

            int delta = y * X;
            for (int x = 0; x < X; x++) {
                int height = Integer.parseInt(st.nextToken());
                heights[delta + x] = height;

                minH = Math.min(minH, height);
                mapBlockHeights += height;
            }
        }

        final int maxH = Math.min(256, Math.floorDiv(mapBlockHeights + inventory, X*Y));

        for (int h = minH; h <= maxH; h++) {
            solve(heights, inventory, h);
        }

        // 그냥 현재 상태가 최적인 경우
        if (minTime == Integer.MAX_VALUE) {
            minTime = 0;
            maxHeight = heights[0];
        }

        System.out.printf("%d %d", minTime, maxHeight);
    }

    private static void solve(int[] heights, int inventory, int targetH) {
        int time = 0;

        for (int h: heights) {
            // 이미 비용 초과하면 진행하는 의미가 없음
            if (time > minTime) {
                return;
            }

            // 같으면 아무것도 안함
            if (h == targetH) {
                continue;
            }

            int diff = Math.abs(h - targetH);

            // 현재 블럭의 높이가 높다면, targetH만큼 제거한다.
            if (h > targetH) {
                time += diff * 2;
                inventory += diff;
                continue;
            }

            inventory -= diff;
            time += diff;
        }

        // 놓친 부분!!!
        // 원래는 for 루프 안에서 inventory < 0 인 경우 return 했다.
        // 하지만 진행 중에 블럭이 모자라도
        // 다른 곳에서 남는 경우가 있을 수 있다!
        // 남은 블록의 갯수가 음수면 불가능
        if (inventory < 0) {
            return;
        }

        // 오래걸렸는지 확인
        if (time > minTime) {
            return;
        }

        // 최소값이면 이게 정답
        if (time < minTime) {
            minTime = time;
            maxHeight = targetH;
            return;
        }

        // 같으면 maxHeight만 큰 값으로 업데이트
        maxHeight = Math.max(maxHeight, targetH);
    }
}
