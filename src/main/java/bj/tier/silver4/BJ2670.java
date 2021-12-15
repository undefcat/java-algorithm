package bj.tier.silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2670 {
    public static void main(String[] args) throws Throwable {
        final BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in), 1<<10
        );

        final int N = Integer.parseInt(br.readLine());

        final double[] doubles = new double[N];

        for (int ni = 0; ni < N; ni++) {
            doubles[ni] = Double.parseDouble(br.readLine());
        }

        br.close();

        double candi = doubles[0];
        double mul = doubles[0];
        for (int ni = 1; ni < N; ni++) {
            mul = Math.max(doubles[ni], mul * doubles[ni]);
            candi = Math.max(candi, mul);
        }

        System.out.printf("%.3f", candi);
    }
}
