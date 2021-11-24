package bj.tier.gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BJ17298 {
    public static void main(String[] args) throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out), 1<<10
        );

        final int N = Integer.parseInt(br.readLine());

        final int[] arr = new int[N];

        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int ni = 0; ni < N; ni++) {
            arr[ni] = Integer.parseInt(st.nextToken());
        }

        // 큰 숫자들을 오름차순으로 갖고 있는 데크
        final Deque<Integer> deq = new ArrayDeque<>(N+1);
        deq.push(arr[N-1]);

        // 정답 배열(역순)
        final List<Integer> reversedAnswer = new ArrayList<>(N+1);
        reversedAnswer.add(-1);

        // 끝에서 왼쪽으로 탐색
        out:
        for (int ni = N-2; ni >= 0; ni--) {
            if (arr[ni] < arr[ni+1]) {
                reversedAnswer.add(arr[ni+1]);
                deq.push(arr[ni+1]);
                continue;
            }

            while (!deq.isEmpty()) {
                final int value = deq.pop();

                if (arr[ni] < value) {
                    reversedAnswer.add(value);
                    deq.push(value);
                    continue out;
                }
            }

            reversedAnswer.add(-1);
            deq.push(arr[ni]);
        }

        for (int ni = N-1; ni >= 0; ni--) {
            bw.write(Integer.toString(reversedAnswer.get(ni)));
            bw.write(' ');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
