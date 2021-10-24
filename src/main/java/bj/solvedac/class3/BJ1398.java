package bj.solvedac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1398 {
    private static final int MAX = 123_456_789;
    private static int N;
    private static boolean[][] isFriend;
    private static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws Throwable {
        init();

        int kevinScore = Integer.MAX_VALUE;
        int user = 1;

        for (int n = 1; n <= N; n++) {
            final int candi = bfs(n);
            if (candi < kevinScore) {
                kevinScore = candi;
                user = n;
            }
        }

        System.out.println(user);
    }

    private static void init() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        isFriend = new boolean[N+1][N+1];

        for (int mi = 0; mi < M; mi++) {
            st = new StringTokenizer(br.readLine(), " ");

            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());

            isFriend[a][b] = true;
            isFriend[b][a] = true;
        }

        br.close();
    }

    private static int bfs(int start) {
        q.clear();

        final boolean[] isVisited = new boolean[N+1];

        q.offer(new Node(start, 0));
        isVisited[start] = true;

        int ans = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            final int a = cur.number;

            for (int b = 1; b <= N; b++) {
                if (!isFriend[a][b]) {
                    continue;
                }

                if (isVisited[b]) {
                    continue;
                }

                isVisited[b] = true;
                Node next = cur.next(b);

                ans += next.score;

                q.offer(next);
            }
        }

        return ans;
    }

    static class Node {
        public final int number;
        public final int score;

        public Node(int number, int score) {
            this.number = number;
            this.score = score;
        }

        public Node next(int number) {
            return new Node(number, score + 1);
        }
    }
}
