package baekjoon.march.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1158
 */
public class JosephusProblem {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 1. INPUT
        // N : 전체 사람 수, K : 건너 뛰기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, K));
    }

    private static StringBuilder solution(int N, int K) {
        // 1 ~ N 사람의 LinkedList 준비
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) queue.offer(i);
        System.out.println("FIRST queue = " + Arrays.toString(queue.toArray()));

        // < , , , > 형태 만들기
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        // 큐가 1개 남을 때 까지, K-1까지 처음에 있던 값을 뒤로 보낸다.
        while(queue.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                // 처음에 있는 값을 빼서 뒤에 다시 집어넣는작업
                queue.add(queue.poll());
                System.out.println("queue = " + Arrays.toString(queue.toArray()));
            }
            StringBuilder element = sb.append(queue.poll());
            System.out.println("element = " + element + ">");
            element.append(", ");
        }
        sb.append(queue.poll());
        sb.append(">");

        return sb;
    }
}
