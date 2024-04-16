package baekjoon.april.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * https://www.acmicpc.net/problem/1251
 */
public class DivideWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        TreeSet<String> set = new TreeSet<>();
        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                String subStr1 = new StringBuilder(input.substring(0, i)).reverse().toString();
                String subStr2 = new StringBuilder(input.substring(i, j)).reverse().toString();
                String subStr3 = new StringBuilder(input.substring(j, length)).reverse().toString();
                set.add(subStr1 + subStr2 + subStr3);
            }
        }
        System.out.println(set.first());
    }
}
