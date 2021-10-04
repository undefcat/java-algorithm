package bj.comito.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10971 {
    private static int N;
    private static int[] order;
    private static int[][] cost;
    private static boolean[] isVisited;

    private static int min = Integer.MAX_VALUE;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        N = Integer.parseInt(br.readLine());

        order = new int[N];
        cost = new int[N][N];
        isVisited = new boolean[N];

        for (int a = 0; a < N; a++) {
            final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int b = 0; b < N; b++) {
                cost[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        for (int start = 0; start < N; start++) {
            isVisited[start] = true;
            order[0] = start;

            traverse(start, 1);

            isVisited[start] = false;
        }

        System.out.println(min);
    }

    private static void traverse(int prev, int visit) {
        if (visit == N) {
            if (isPathNotExist(order[N-1], order[0])) {
                return;
            }

            calc();

            return;
        }

        for (int next = 0; next < N; next++) {
            if (isVisited[next]) {
                continue;
            }

            if (isPathNotExist(prev, next)) {
                continue;
            }

            isVisited[next] = true;
            order[visit] = next;
            traverse(next, visit+1);
            isVisited[next] = false;
        }
    }

    private static boolean isPathNotExist(int a, int b) {
        return cost[a][b] == 0;
    }

    private static void calc() {
        int sum = 0;

        for (int n = 1; n < N; n++) {
            sum += cost[order[n-1]][order[n]];
        }

        sum += cost[order[N-1]][order[0]];

        min = Math.min(min, sum);
    }
}
