package bj.solvedac.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ7568 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        final int N = Integer.parseInt(br.readLine());

        Human[] humans = new Human[N];

        for (int ni = 0; ni < N; ni++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int weight = Integer.parseInt(st.nextToken());
            int tall = Integer.parseInt(st.nextToken());

            humans[ni] = new Human(weight, tall);
        }

        for (int a = 0; a < N; a++) {
            Human h1 = humans[a];

            for (int b = 0; b < N; b++) {
                if (a == b) {
                    continue;
                }

                Human h2 = humans[b];

                if (h1.lower(h2)) {
                    h1.rank++;
                }
            }
        }

        for (Human h: humans) {
            bw.write(Integer.toString(h.rank));
            bw.write(' ');
        }

        bw.flush();
    }

    static class Human {
        private final int weight;
        private final int tall;
        public int rank = 1;

        Human(int weight, int tall) {
            this.weight = weight;
            this.tall = tall;
        }

        public boolean lower(Human o) {
            return this.weight < o.weight && this.tall < o.tall;
        }
    }
}
