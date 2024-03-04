package programmers.march.second;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java
 */
public class CorrectParentheses {
    private static final char OPEN = '(';

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(OPEN);
            } else {
                if (stack.empty()) return false;
                stack.pop();
            }
        }
        if (stack.empty()) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
}
