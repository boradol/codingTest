package baekjoon.march.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * https://www.acmicpc.net/problem/1213
 */
public class Palindrome {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 알파벳 대문자 최대 50자까지
        String input = br.readLine();

        // 순서대로 input의 문자열을 담으면서 그 해당 값이 몇개씩 들어가는지 세기
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char key = input.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        // oddNum : 홀수개인 문자가 몇 개인지 판별하는 변수
        // - 우리는 1개만 필요하다. 그 middleChar 에 홀수개인 문자 하나 넣기.
        // - 2개이상이면  "I'm Sorry Hansoo"
        int oddNum = 0;
        Character middleChar = null;

        // 짝수개 있으면 StringBuilder에 담아준다. - 단, 짝수개의 반절만큼 해당 문자를 반복해서 넣어줘야 한다.
        // 홀수개 있으면 홀수 개수
        for (Character key : map.keySet()) {
            Integer value = map.get(key);
            sb.append(String.valueOf(key).repeat(value / 2));
            if (value % 2 != 0) {
                oddNum++;
                middleChar = key;
                if (oddNum > 1) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }

        // 답 집어넣기.
        // answer + middlechar(존재할경우) + sb.reverse()
        String answer = sb.toString();
        sb.reverse();
        if (oddNum == 1) {
            sb.insert(0, middleChar);
        }
        sb.insert(0, answer);

        System.out.println(sb);
    }
}
