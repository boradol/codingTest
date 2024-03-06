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
            if (verify(str, set, i)) return false;
            set.add(str.charAt(i));
        }
        return true;
    }

    private static boolean verify(String str, Set<Character> set, int i) {
        return set.contains(str.charAt(i)) && (str.charAt(i) != str.charAt(i - 1));
    }
}
