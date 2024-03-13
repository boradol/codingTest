package baekjoon.march.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7568
 */
public class BigSmall {
    private static final StringBuilder sb = new StringBuilder();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 1. INPUT
        // 전체 사람의 수
        int N = Integer.parseInt(br.readLine());
        // 각 사람의 몸무게와 키 배열 (x, y가 하나의 공백을 두고 각각 나타냄)
        List<Person> people = new ArrayList<>();
        inputPeople(N, people);

        // 2. LOGIC
        ranking(people);

        // 3. PRINT
        System.out.println(sb);
    }

    private static void inputPeople(int N, List<Person> people) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people.add(i, new Person(st.nextToken(), st.nextToken()));
        }
        System.out.println("people = " + people);
    }

    private static void ranking(List<Person> people) {
        for (int i = 0; i < people.size(); i++) {
            int rank = 1;
            for (int j = 0; j < people.size(); j++) {
                if (i == j) continue;
                if (people.get(i).compare(people.get(j))) {
                    rank++;
                }
            }
            sb.append(rank).append(' ');
        }
    }

    static class Person {
        int weight;
        int height;

        public Person(String weight, String height) {
            this(Integer.parseInt(weight), Integer.parseInt(height));
        }

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        // 몸무게와 키가 둘다 커야하는 비교법
        public boolean compare(Person person) {
            return this.height < person.height && this.weight < person.weight;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "weight=" + weight +
                    ", height=" + height +
                    '}';
        }
    }
}
