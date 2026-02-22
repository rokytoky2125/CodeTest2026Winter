package week6.boj.p1931;


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end));
        }

        solve(list);

        System.out.println(sb.toString());
    }

    // 그리디-Interval Scheduling
    static void solve(List<Node> list) {

        // 1. 정렬
        Collections.sort(list, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int count = 0;
        int prevEndTime = 0;

        for (Node curr : list) {
            // 2. 조건 검사 및 상태 갱신
            if (curr.start >= prevEndTime) {
                count++;
                prevEndTime = curr.end;
            }
        }

        sb.append(count).append('\n');
    }
}