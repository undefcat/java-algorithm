package bj.comito.week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1261 {
    private static final byte ROOM = '0';
    private static final byte WALL = '1';

    private static int X;
    private static int Y;

    private static byte[][] maze;
    private static int[][] dist;
    private static boolean[][] visited;

    public static void main(String[] args) throws Throwable {
        input();
        bfs();

        System.out.println(dist[Y-1][X-1]);
    }

    private static void input() throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        maze = new byte[Y][];
        dist = new int[Y][X];
        visited = new boolean[Y][X];

        for (int[] row: dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        for (int ni = 0; ni < Y; ni++) {
            maze[ni] = br.readLine().getBytes();
        }

        br.close();
    }

    private static void bfs() {
        PriorityQueue<Coordinate> q = new PriorityQueue<>();

        q.offer(new Coordinate(0, 0));

        while (!q.isEmpty()) {
            Coordinate current = q.poll();

            Coordinate[] neighbors = current.getNeighbors();

            for (Coordinate neighbor: neighbors) {
                if (neighbor == null) {
                    break;
                }

                int cost = current.getDist() + current.weightTo(neighbor);
                if (cost < neighbor.getDist()) {
                    dist[neighbor.y][neighbor.x] = cost;
                    q.offer(neighbor);
                }
            }
        }
    }

    static class Coordinate implements Comparable<Coordinate> {
        private static final int[][] delta = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
        };

        public final int y;
        public final int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;

            visited[y][x] = true;
        }

        public Coordinate[] getNeighbors() {
            final Coordinate[] ret = new Coordinate[4];

            int i = 0;
            for (int[] d: delta) {
                int dy = y + d[0];
                int dx = x + d[1];

                if (canVisit(dy, dx)) {
                    ret[i++] = new Coordinate(dy, dx);
                }
            }

            return ret;
        }

        private boolean canVisit(int y, int x) {
            return (y >= 0 && y < Y && x >= 0 && x < X)
                    && !visited[y][x];
        }

        public int getDist() {
            return dist[y][x];
        }

        public int weightTo(Coordinate o) {
            return maze[o.y][o.x] == WALL ? 1 : 0;
        }

        public int distTo(Coordinate o) {
            return dist[y][x] + dist[o.y][o.x];
        }

        @Override
        public int compareTo(Coordinate o) {
            return dist[y][x] - dist[o.y][o.x];
        }
    }
}
