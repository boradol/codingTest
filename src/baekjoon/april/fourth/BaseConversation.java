package baekjoon.april.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11576
 */
public class BaseConversation {

    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        
        // 입력
        StringTokenizer st = new StringTokenizer(BR.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(BR.readLine());
        StringTokenizer st2 = new StringTokenizer(BR.readLine());
        
        // A진수에서 10진수로 변환
        int decimal = 0;
        for (int i = m - 1; i >= 0; i--) {
            int n = Integer.parseInt(st2.nextToken());
            decimal += n * Math.pow(A, i);
        }

        // 10진수에서 B진수로 변환
        int result = decimal;
        while (result != 0) {
            sb.insert(0, result % B + SPACE);
            result /= B;
        }
        System.out.println(sb);
    }
}
