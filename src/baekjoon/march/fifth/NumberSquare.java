package baekjoon.march.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1051
 */
public class NumberSquare {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int MIN_SQUARE_SIZE = 1;

    public static void main(String[] args) throws IOException {
        // 1. INPUT
        // N X M 직사각형 => 2차원 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] points = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            points[i] = line.toCharArray();
        }
        System.out.println(solution(N, M, points));
    }

    private static int solution(int N, int M, char[][] points) {
        // 2. squareSize = 정사각형의 최대 크기는 N과 M중에서 작은 수를 선택한다.
        // 3. squareSize 부터 1까지 차례대로 정사각형 크기의 조건을 만족하는 것을 찾아본다.
        //      가장 큰 정사각형을 찾아야 하니 큰 것부터 찾는다.
            /*
                - point(기준 꼭짓점) = points[i][j]
                - squareSize(정사각형 크기) = 3 (N과 M중에 작은 수)
                - distance(다음 꼭짓점이 되기위한 인덱스의 간격) = squareSize - 1 = 2
                ex)
                             |distance|
                   | 0 | 1 | 2 | 3 | 4 |
                ------------------------
                 0 | 4   2  '1'  0  '1'| ← index = [N - squareSize]
                 1 | 2   2   1   0   0 |
                 2 | 2   2  '1'  0  '1'|
                ------------------------
                             ↑
                  index = [M - squareSize]
            */
        int squareSize = Math.min(N, M);
        while (squareSize > MIN_SQUARE_SIZE) {
            for (int i = 0; i <= N - squareSize; i++) {
                for (int j = 0; j <= M - squareSize; j++) {
                    char value = points[i][j];
                    int distance = squareSize - 1;
                    if (value == points[i][j + distance] &&
                        value == points[i + distance][j] &&
                        value == points[i + distance][j + distance]) {
                        return squareSize * squareSize;
                    }
                }
            }
            squareSize--;
        }
        return MIN_SQUARE_SIZE;
    }
}
