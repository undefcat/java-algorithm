package bj.comito.codeplus.basic.week01;

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

        // 시작점으로부터 5개의 노드를 방문하지 못한 경우
        // 그 다음 시작점부터 다시 시작하는데,
        // 이 때 visited를 초기화하지 않으면
        // 그 다음 노드의 탐색이 제대로 이루어지지 않는다!
        for (Node n: nodes) {
            n.dfs(1);
        }

        System.out.println("0");
    }

    static class Node {
        boolean visited = false;
        List<Node> neighbors = new LinkedList<>();

        public void dfs(int visit) {
            // 5개의 노드를 만났다면
            // A -> B -> C -> D -> E 의 관계가 성립하는 것이다!
            if (visit >= 5) {
                System.out.println("1");
                System.exit(0);
            }

            visited = true;

            for (Node n: neighbors) {
                if (n.visited) {
                    continue;
                }

                n.dfs(visit+1);
            }

            visited = false;
        }
    }
}
