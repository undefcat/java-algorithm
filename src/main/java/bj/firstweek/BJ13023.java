package bj.firstweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ13023 {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].neighbors.add(nodes[b]);
            nodes[b].neighbors.add(nodes[a]);
        }

        for (Node n: nodes) {
            if (n.visited) {
                continue;
            }

            n.dfs(0);
        }

        System.out.println("0");
    }

    static class Node {
        boolean visited = false;
        List<Node> neighbors = new LinkedList<>();

        public void dfs(int depth) {
            depth += 1;
            if (depth >= 5) {
                System.out.println("1");
                System.exit(0);
            }

            for (Node n: neighbors) {
                if (n.visited) {
                    continue;
                }

                n.visited = true;
                n.dfs(depth);
            }
        }
    }
}
