package bj.solvedac.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10814 {
    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<16
    );

    private static final BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out), 1<<16
    );

    public static void main(String[] args) throws Throwable {
        final int N = Integer.parseInt(br.readLine());

        Member[] members = new Member[N];

        for (int ni = 0; ni < N; ni++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members[ni] = new Member(ni, age, name);
        }

        Arrays.sort(members);

        for (Member m: members) {
            bw.write(Integer.toString(m.age));
            bw.write(' ');
            bw.write(m.name);
            bw.write('\n');
        }

        bw.flush();
    }

    static class Member implements Comparable<Member> {
        public final String name;
        public final int age;

        private final int index;

        public Member(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age == o.age) {
                return this.index - o.index;
            }

            return this.age - o.age;
        }
    }
}
