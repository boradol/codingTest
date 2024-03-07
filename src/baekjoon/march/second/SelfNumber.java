package baekjoon.march.second;

/**
 * https://www.acmicpc.net/problem/4673
 */
public class SelfNumber {
    public static void main(String[] args) {
        int maxNum = 10000;
        Boolean[] numbers = new Boolean[maxNum + 1];
        // 생성되는 숫자 찾기
        verify(maxNum, numbers);
        // 셀프넘버 찾기
        StringBuilder sb = findSelfNumbers(maxNum, numbers);

        System.out.println(sb);
    }

    private static StringBuilder findSelfNumbers(int maxNum, Boolean[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= maxNum; i++) {
            if (numbers[i] == null) {
                sb.append(i).append("\n");
            }
        }
        return sb;
    }

    private static void verify(int maxNum, Boolean[] numbers) {
        for (int n = 0; n <= maxNum; n++) {
            // 이 조건문을 안넣어주면 ArrayIndexOutOfBounds 가 나서 넣어 줌.
            if (d(n) <= maxNum) {
                numbers[d(n)] = true;
            }
        }
    }

    private static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
