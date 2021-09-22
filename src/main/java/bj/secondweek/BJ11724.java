package bj.secondweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ11724 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N+1];

        for (int n = 1; n <= N; n++) {
            nodes[n] = new Node();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].siblings.add(nodes[b]);
        }

        int count = 0;
        for (int n = 1; n <= N; n++) {
            Node node = nodes[n];
            if (node.visited) {
                continue;
            }

            count++;
            node.dfs();
        }

        System.out.println(count);
    }

    static class Node {
        List<Node> siblings = new LinkedList<>();
        boolean visited = false;

        public void dfs() {
            if (visited) {
                return;
            }

            visited = true;

            for (Node n: siblings) {
                n.dfs();
            }
        }
    }
}
