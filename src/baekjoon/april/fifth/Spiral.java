package baekjoon.april.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1491
 */
public class Spiral {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int row = 0;
        int col = 0;

        for (int i = 0; i < Math.min(m, n) * 2; i++) {
            if (i == 0) row = n - 1;
            if (i != 0 && i % 4 == 0) row += --n;
            else if (i % 4 == 1) col += --m;
            else if (i % 4 == 2) row -= --n;
            else if (i % 4 == 3) col -= --m;
        }
        System.out.printf("%d %d", row, col);
    }
}
