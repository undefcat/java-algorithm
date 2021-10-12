package bj.comito.week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ14226 {
    private static final boolean[][] visited = new boolean[2001][2001];

    private static int S;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws Throwable {
        S = Integer.parseInt(br.readLine());

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<State> q = new LinkedList<>();

        q.offer(new State(0, 1, 0));

        visited[1][0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.screen == S) {
                return cur.time;
            }

            // 1. 화면에 있는 이모티콘 클립보드에 복사
            q.offer(cur.copy().checkVisited());

            // 2. 클립보드 이모티콘 붙여넣기
            if (cur.canPaste()) {
                q.offer(cur.paste().checkVisited());
            }

            // 3. 하나 지우기
            if (cur.canRemove()) {
                q.offer(cur.remove().checkVisited());
            }
        }

        throw new RuntimeException("UNREACHABLE CODE");
    }

    static class State {
        public final int clipboard;
        public final int screen;
        public final int time;

        public State(int clipboard, int screen, int time) {
            this.clipboard = clipboard;
            this.screen = screen;
            this.time = time;
        }

        public State copy() {
            return new State(screen, screen, time+1);
        }

        public boolean canPaste() {
            if (clipboard == 0) {
                return false;
            }

            int newScreen = screen + clipboard;
            if (newScreen > 2000) {
                return false;
            }

            return !visited[newScreen][clipboard];
        }

        public State paste() {
            return new State(clipboard, screen + clipboard, time+1);
        }

        public boolean canRemove() {
            if (screen <= 1) {
                return false;
            }

            return !visited[screen-1][clipboard];
        }

        public State remove() {
            return new State(clipboard, screen-1, time+1);
        }

        public State checkVisited() {
            visited[screen][clipboard] = true;

            return this;
        }
    }
}
