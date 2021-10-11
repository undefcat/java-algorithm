package bj.comito.week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1759 {
    private static int L;
    private static int C;

    private static byte[] bytes;
    // 해당 bytes index 뒤에 몇개의 모음이 있는지?
    private static int[] afterVowels;
    // 해당 bytes index 뒤에 몇개의 자음이 있는지?
    private static int[] afterConsonants;

    private static byte[] picked;
    private static boolean[] used;

    private static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in), 1<<10
    );

    private static final StringBuilder sb = new StringBuilder(1<<16);

    public static void main(String[] args) throws Throwable {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bytes = new byte[C];
        afterVowels = new int[C];
        afterConsonants = new int[C];
        picked = new byte[L];
        used = new boolean[C];

        int i = 0;
        for (byte b: br.readLine().getBytes()) {
            if (b == ' ') {
                continue;
            }

            bytes[i++] = b;
        }

        Arrays.sort(bytes);

        int last = bytes.length - 1;
        if (isVowel(bytes[last])) {
            afterVowels[last] = 1;
        } else {
            afterConsonants[last] = 1;
        }

        for (i = last-1; i >= 0; i--) {
            if (isVowel(bytes[i])) {
                afterVowels[i] = afterVowels[i+1] + 1;
                afterConsonants[i] = afterConsonants[i+1];
            } else {
                afterVowels[i] = afterVowels[i+1];
                afterConsonants[i] = afterConsonants[i+1] + 1;
            }
        }

        pick(0, 0, 0, 0);

        System.out.println(sb);
    }

    private static void pick(int vowels, int consonants, int start, int idx) {
        if (idx == L) {
            if (vowels >= 1 && consonants >= 2) {
                appendWord();
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (used[i]) {
                continue;
            }

            // 현재 모음을 하나도 못뽑았는데, 앞으로 뽑을 수 있는 모음도 0개면
            // 더 이상 탐색의 의미가 없다.
            if (vowels == 0 && afterVowels[i] == 0) {
                return;
            }

            // 최소 2개 이상은 뽑아야 하는데
            // 남은 필요한 자음보다 앞으로 뽑을 수 있는 자음의 갯수가 적으면
            // 더 이상 탐색의 의미가 없다.
            int needConsonants = 2 - consonants;
            if (needConsonants >= 0 && needConsonants > afterConsonants[i]) {
                return;
            }

            used[i] = true;
            picked[idx] = bytes[i];
            if (isVowel(bytes[i])) {
                pick(vowels+1, consonants, i+1, idx+1);
            } else {
                pick(vowels, consonants+1, i+1, idx+1);
            }

            used[i] = false;
        }
    }

    private static void appendWord() {
        for (byte b: picked) {
            sb.append((char)b);
        }
        sb.append('\n');
    }

    private static boolean isVowel(byte c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
