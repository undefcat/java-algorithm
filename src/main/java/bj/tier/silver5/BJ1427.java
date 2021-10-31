package bj.tier.silver5;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BJ1427 {
    public static void main(String[] args) throws Throwable {
        final Scanner sc = new Scanner(System.in);
        final BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(System.out), 1<<5
        );

        final byte[] bytes = sc.nextLine().getBytes();

        int[] ints = IntStream.range(0, bytes.length)
                .map(i -> bytes[i])
                .toArray();

        Arrays.sort(ints);

        for (int i = ints.length - 1; i >= 0; i--) {
            bw.write(ints[i]);
        }

        bw.flush();
        bw.close();
        sc.close();
    }
}
