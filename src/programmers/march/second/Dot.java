package programmers.march.second;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/140107
 */
public class Dot {
    public static long solution(int k, int d) {
        long answer = 0;
        for(long x = 0; x <= d; x += k){
            long y = (long) Math.sqrt((long)d*d - x*x);
            answer += y / k + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4));
        System.out.println(solution(1, 5));
    }
}
