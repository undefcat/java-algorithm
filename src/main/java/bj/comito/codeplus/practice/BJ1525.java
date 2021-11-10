package bj.comito.codeplus.practice;

import java.util.*;

public class BJ1525 {
    // 1111
    private static final long MASK = 15L;

    // 1000 0111 0110 0101 0100 0011 0010 0001
    private static final long GOAL = 2271560481L;

    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);

        long arr = 0;

        for (int i = 0; i < 9; i++) {
            arr = set(arr, i, sc.nextInt());
        }

        sc.close();

        System.out.println(bfs(arr));
    }

    private static String bfs(final long bitArray) {
        final Deque<long[]> q = new LinkedList<>();
        final Map<Long, Boolean> visited = new HashMap<>(40_320); // 8!
        final int[] swapDeltas = {-3, -1, 1, 3};

        q.offer(new long[]{bitArray, 0});
        visited.put(bitArray, true);

        while (!q.isEmpty()) {
            long[] cur = q.poll();

            if (cur[0] == GOAL) {
                return Long.toString(cur[1]);
            }

            final int a = getZeroIndex(cur[0]);

            // a index와 b index를 교환할 때,
            // 게임 보드 판에서 a의 상하좌우 index에 b가 위치한다.
            for (int delta: swapDeltas) {
                final int b = a + delta;

                if (!canSwap(a, b)) {
                    continue;
                }

                final long next = swap(cur[0], a, b);
                if (visited.containsKey(next)) {
                    continue;
                }

                visited.put(next, true);
                q.offer(new long[]{next, cur[1]+1});
            }
        }

        return "-1";
    }

    private static int get(final long bitArray, final int i) {
        final long result = bitArray >> (i*4);

        return (int)(result & MASK);
    }

    private static long set(final long bitArray, final int i, final long number) {
        final long target = number << (i*4);
        final long mask = MASK << (i*4);

        return (bitArray & ~mask) | target;
    }

    private static int getZeroIndex(final long bitArray) {
        for (int i = 0; i < 9; i++) {
            if (get(bitArray, i) == 0) {
                return i;
            }
        }

        throw new RuntimeException("UNREACHABLE CODE");
    }

    private static boolean canSwap(final int zero, final int target) {
        if (target < 0 || target >= 9) {
            return false;
        }

        final int[][] dirs = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
        };

        final int[] aPos = {zero/3, zero%3};
        final int[] bPos = {target/3, target%3};

        for (int[] dir: dirs) {
            int y = aPos[0] + dir[0];
            int x = aPos[1] + dir[1];

            if (y == bPos[0] && x == bPos[1]) {
                return true;
            }
        }

        return false;
    }


    private static long swap(final long bitArray, final int a, final int b) {
        final int numberA = get(bitArray, a);
        final int numberB = get(bitArray, b);

        long result = set(bitArray, a, numberB);
        result = set(result, b, numberA);

        return result;
    }
}
