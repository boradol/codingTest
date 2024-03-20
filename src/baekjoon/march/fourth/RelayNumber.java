package baekjoon.march.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1748
 */
public class RelayNumber {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
        // 입력받지않고 출력하기
//        System.out.println(solution(5));
//        System.out.println(solution(15));
//        System.out.println(solution(120));
//        System.out.println(solution(100_000_000));
    }

    // N = 15
    // 1~ 9,  result +1 씩
    // 10 -> Plus = 2
    // 10 ~ 15, result  +2씩
    private static long solution(int N) {
        long start = System.currentTimeMillis();
        long result = 0; // 결과
        int plus = 1;
        long divider = 10;

        for (int i = 1; i <= N; i++) {
            // N의 자릿수가 바뀌는 순간
            if (i % divider == 0) {
                // 각 자리마다 +1씩
                // 예)   i = 10,
                plus++;         //      plus = 2
                divider *= 10;  //      divider = 100
            }

            // 결과 더하기
            result += plus;
        }
        long end = System.currentTimeMillis();
        System.out.println("timestamp = " + (end - start));

        return result;
    }
}

// review내용 : long으로 받을 시 주의하라!
