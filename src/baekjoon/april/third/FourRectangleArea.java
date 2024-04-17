package baekjoon.april.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2669
 */
public class FourRectangleArea {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int LINE_NUM = 4;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int[][] board = new int[101][101];
        //입력
        for (int i = 0; i < LINE_NUM; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            //해당 면적 1로 채워주기
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    board[j][k] = 1;
                }
            }
        }

        //값 구하기
        int result = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if(board[i][j] == 1) result++;
            }
        }
        System.out.println(result);
    }
}
