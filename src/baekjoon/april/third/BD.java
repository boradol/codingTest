package baekjoon.april.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
    https://www.acmicpc.net/problem/5635
 */
public class BD {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String day = String.format("%02d", Integer.parseInt(st.nextToken()));
            String month = String.format("%02d", Integer.parseInt(st.nextToken()));
            String year = st.nextToken();
            map.put(Integer.parseInt(year+month+day), name);
        }

        System.out.println(map.lastEntry().getValue());
        System.out.println(map.firstEntry().getValue());
    }
}
