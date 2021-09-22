package bj.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1966 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine(), " ");

            for (int n = 0; n < N; n++) {
                int priority = Integer.parseInt(st.nextToken());
                Node node = new Node(n == M, priority);

                q.add(node);
                pq.add(priority);
            }

            int printed = 0;
            int maxPriority = pq.remove();
            while (!q.isEmpty()) {
                Node n = q.remove();

                if (n.isTarget && maxPriority == n.priority) {
                    System.out.println(printed + 1);
                    break;
                }

                if (n.priority == maxPriority) {
                    printed++;
                    maxPriority = pq.remove();
                } else {
                    q.add(n);
                }
            }
        }

    }

    static class Node {
        boolean isTarget;
        int priority;

        public Node(boolean isTarget, int priority) {
            this.isTarget = isTarget;
            this.priority = priority;
        }
    }
}
