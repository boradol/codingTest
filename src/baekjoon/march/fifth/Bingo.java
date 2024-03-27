package baekjoon.march.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2578
 */
public class Bingo {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String SPACE = " ";
    private static final int BINGO_LINE_COUNT = 5;
    private static final int BINGO_COUNT = 3;
    private static final int MATCH_CHECK = 0;

    public static void main(String[] args) throws IOException {
        // 1. 빙고 입력받기
        int[][] gamer = makeBingoBoard();
        int[] caller = Arrays.stream(makeBingoBoard()).flatMapToInt(Arrays::stream).toArray();
        System.out.println(solution(gamer, caller));
    }

    private static int solution(int[][] gamer, int[] caller) {
        // 2. MC가 부른 숫자가 gamer의 빙고판과 일치하는 인덱스 확인 -> 0으로 체크
        int matchCount = 0;
        int bingoCount = 0;
        for (int call : caller) {
            for (int i = 0; i < BINGO_LINE_COUNT; i++) {
                for (int j = 0; j < BINGO_LINE_COUNT; j++) {
                    if (gamer[i][j] == call) {
                        // 사회자가 부른 숫자랑 일치하면 => 0 넣기
                        gamer[i][j] = MATCH_CHECK;
                        // 일치하는 숫자 count 세기
                        matchCount++;
                        // 빙고 개수 세기
                        bingoCount = checkBingoCount(bingoCount, gamer, i, j);
                        // 3개이상이면 답 출력하기
                        if (bingoCount >= BINGO_COUNT) {
                            return matchCount;
                        }
                    }
                }
            }
        }
        // 여기까지는 올 일은 없다.
        return matchCount;
    }

    // 빙고 만들기 함수
    private static int[][] makeBingoBoard() throws IOException {
        int[][] bingo = new int[BINGO_LINE_COUNT][BINGO_LINE_COUNT];
        for (int i = 0; i < BINGO_LINE_COUNT; i++) {
            String line = br.readLine();
            bingo[i] = Arrays.stream(line.split(SPACE))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return bingo;
    }

    private static int checkBingoCount(int bingoCount, int[][] gamer, int i, int j) {
        // row, column 일치 여부
        if (isBingoRowLine(i, gamer)) {
            bingoCount++;
        }

        if (isBingoColumnLine(j, gamer)) {
            bingoCount++;
        }

        // 대각선 일치 여부
        if ((i + j == BINGO_LINE_COUNT - 1) && isBingoDiagonalRightUp(gamer)) {
            bingoCount++;
        }

        if ((i == j) && isBingoDiagonalRightDown(gamer)) {
            bingoCount++;
        }

        return bingoCount;
    }

    private static boolean isBingoRowLine(int rowIndex, int[][] gamer) {
        for (int i = 0; i < BINGO_LINE_COUNT; i++) {
            if (gamer[rowIndex][i] != MATCH_CHECK) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBingoColumnLine(int columnIndex, int[][] gamer) {
        for (int i = 0; i < BINGO_LINE_COUNT; i++) {
            if (gamer[i][columnIndex] != MATCH_CHECK) {
                return false;
            }
        }
        return true;
    }


    private static boolean isBingoDiagonalRightUp(int[][] gamer) {
        for (int i = 0; i < BINGO_LINE_COUNT; i++) {
            if (gamer[i][BINGO_LINE_COUNT - i - 1] != MATCH_CHECK) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBingoDiagonalRightDown(int[][] gamer) {
        for (int i = 0; i < BINGO_LINE_COUNT; i++) {
            if (gamer[i][i] != MATCH_CHECK) {
                return false;
            }
        }
        return true;
    }
}
