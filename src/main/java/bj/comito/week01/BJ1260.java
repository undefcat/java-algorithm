package bj.comito.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1260 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N+1];
        for (int num = 1; num <= N; num++) {
            nodes[num] = new Node(num);
        }

        boolean[][] isConnected = new boolean[N+1][N+1];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            isConnected[a][b] = true;
            isConnected[b][a] = true;
        }

        for (int i = 1; i <= N; i++) {
            Node n = nodes[i];
            int a = n.num;

            for (int b = 1; b <= N; b++) {
                if (isConnected[a][b]) {
                    n.siblings.add(nodes[b]);
                }
            }
        }

        Node starter = nodes[V];

        starter.dfs();

        Node.sb.append('\n');

        Node.bfs(starter);

        System.out.println(Node.sb);
    }

    static class Node {
        public static StringBuilder sb = new StringBuilder(100_000);

        public int num = 0;
        public boolean isVisitedDfs = false;
        public boolean isVisitedBfs = false;
        public List<Node> siblings = new ArrayList<>();

        Node(int num) {
            this.num = num;
        }

        public void dfs() {
            isVisitedDfs = true;

            sb.append(num);
            sb.append(' ');

            for (Node n: siblings) {
                if (n.isVisitedDfs) {
                    continue;
                }

                n.dfs();
            }
        }

        public static void bfs(Node start) {
            Queue<Node> queue = new ArrayDeque<>(1001);

            queue.add(start);
            start.isVisitedBfs = true;

            while (!queue.isEmpty()) {
                Node n = queue.poll();

                sb.append(n.num);
                sb.append(' ');

                for (Node s: n.siblings) {
                    if (s.isVisitedBfs) {
                        continue;
                    }

                    s.isVisitedBfs = true;
                    queue.add(s);
                }
            }
        }
    }
}
