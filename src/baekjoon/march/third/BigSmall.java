package baekjoon.march.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/7568
 */
public class BigSmall {
    private static final String SPACE = " ";
    private static final StringBuilder sb = new StringBuilder();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 1. INPUT
        // 전체 사람의 수
        int N = Integer.parseInt(br.readLine());
        // 각 사람의 몸무게와 키 배열 (x, y가 하나의 공백을 두고 각각 나타냄)
        List<Person> people = new ArrayList<>();
        inputPeople(N, people);

        // LOGIC
        ranking(people);

        // PRINT
        System.out.println(sb);
    }

    private static void inputPeople(int N, List<Person> people) throws IOException {
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(SPACE);
            people.add(i, new Person(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
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

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

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
