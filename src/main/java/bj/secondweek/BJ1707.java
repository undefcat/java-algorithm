package bj.secondweek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1707 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        int K = Integer.parseInt(br.readLine());

        testCase:
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            Node[] nodes = initNodes(V, E);

            Deque<Node> stack = new ArrayDeque<>();

            // BFS로 돌렸는데
            // Connected Components가 여러개인 경우를 고려 못하고
            // 돌려서 틀렸었다.
            for (int v = 1; v <= V; v++) {
                if (nodes[v].status != Status.NON_VISIT) {
                    continue;
                }

                nodes[v].status = Status.GROUP_A;
                stack.push(nodes[v]);

                while (!stack.isEmpty()) {
                    Node node = stack.pop();

                    for (Node n: node.siblings) {
                        if (n.status == Status.NON_VISIT) {
                            n.status = node.status.getOpposition();

                            stack.push(n);
                            continue;
                        }

                        if (n.status == node.status) {
                            System.out.println("NO");

                            continue testCase;
                        }
                    }
                }
            }

            System.out.println("YES");
        }
    }

    private static Node[] initNodes(int V, int E) throws Throwable {
        Node[] nodes = new Node[V+1];

        for (int v = 1; v <= V; v++) {
            nodes[v] = new Node(v);
        }

        for (int e = 1; e <= E; e++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            nodes[v1].siblings.add(nodes[v2]);
            nodes[v2].siblings.add(nodes[v1]);
        }

        return nodes;
    }

    static enum Status {
        NON_VISIT, GROUP_A, GROUP_B;

        public Status getOpposition() {
            switch (this) {
                case GROUP_A:
                    return GROUP_B;

                case GROUP_B:
                    return GROUP_A;
            }

            throw new RuntimeException("NON_VISIT Can't call this method");
        }
    }

    static class Node {
        List<Node> siblings = new LinkedList<>();
        Status status = Status.NON_VISIT;
        int num;

        Node(int num) {
            this.num = num;
        }
    }
}
