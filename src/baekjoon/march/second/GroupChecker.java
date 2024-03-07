package baekjoon.march.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.acmicpc.net/problem/1316
 */
class GroupChecker {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (cheack()) count++;
        }
        System.out.println(count);
    }

    public static boolean cheack() throws IOException {
        Set<Character> set = new HashSet<>();
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            // 한글자일 때
            if (str.length() == 1) return true;

            // 여러글자일 때 검증
            // 1. set 에 지금 인덱스의 문자가 있는지 체크
            // 2. 지금 인덱스 문자와 이전 인덱스 문자가 같은지 비교
            if (set.contains(str.charAt(i)) && (str.charAt(i) != str.charAt(i - 1))) return false;
            set.add(str.charAt(i));
        }
        return true;
    }
}
