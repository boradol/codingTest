package baekjoon.april.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5800
 */
public class GradeStatistics {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // Class 수 입력 받기
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            // Class에 따른 학생수 입력 받기
            int n = Integer.parseInt(st.nextToken());
            // Class의 점수 입력받아 점수 list에 넣기
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            // list 내림차순으로 정렬 후 Largest Gap 계산 하기. Max는 index 0에 위치 Min은 마지막 index
            int maxDiff = 0;
            list.sort(Collections.reverseOrder());
            for (int j = 1; j < list.size(); j++) {
                int diff = list.get(j - 1) - list.get(j);
                if (diff > maxDiff) maxDiff = diff;
            }
            // 출력
            sb.append("Class ").append(i + 1).append("\n");
            sb.append("Max ").append(list.get(0)).append(", Min ").append(list.get(list.size() - 1)).append(", Largest gap ").append(maxDiff).append("\n");
        }
        System.out.println(sb);
    }
}
