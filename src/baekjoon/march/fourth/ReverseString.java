package baekjoon.march.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/17413
 */
public class ReverseString {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final char SPACE = ' ';
    private static final char OPEN_TAG = '<';
    private static final char CLOSE_TAG = '>';

    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            // 1. '<' 일 때, 태그시작이므로 순서대로 출력
            if (S.charAt(i) == OPEN_TAG) {
                int j;
                for (j = i; S.charAt(j) != CLOSE_TAG; j++) {
                    sb.append(S.charAt(j));
                }
                sb.append(CLOSE_TAG);
                i = j;
            }
            // 2. ' ' 일 때, 공백 그대로 출력
            else if (S.charAt(i) == SPACE) {
                sb.append(SPACE);
            }
            // 3. 공백도 아니고, 태그안의 값이 아니면, 차례대로 stack에 전체에 push()후 전체 pop()한 것을 append()한다.
            else {
                int j;
                for (j = i; j < S.length() && S.charAt(j) != SPACE && S.charAt(j) != OPEN_TAG; j++) {
                    stack.push(S.charAt(j));
                }
                int size = stack.size();
                for (int q = 0; q < size; q++) {
                    sb.append(stack.pop());
                }
                i = j - 1;
            }
        }
        System.out.println(sb);
    }
}
