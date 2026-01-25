package week1.programmers.lv3;

import java.util.*;

class P43162 {

    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];

        // 전체 순회
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, n, computers);
            }
        }

        return answer;
    }

    // 땅따먹기
    void dfs(int current, int n, int[][] computers) {
        // 즉시 처리
        visited[current] = true;

        // 연결된 노드 탐색
        for (int i = 0; i < n; i++) {
            if (computers[current][i] == 1 && !visited[i]) { // 문제 요구 조건
                dfs(i, n, computers);
            }
        }
    }


    public static void main(String[] args) {
        P43162 s = new P43162();

        // 테스트 케이스 1
        int n1 = 3;
        int[][] com1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println("Test 1: " + s.solution(n1, com1)); // Expected: 2

        // 테스트 케이스 2
        int n2 = 3;
        int[][] com2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println("Test 2: " + s.solution(n2, com2)); // Expected: 1

        int n3 = 1;
        int[][] com3 = {{1}};
        System.out.println("Test 3 (Edge - Min): " + s.solution(n3, com3)); // Expected: 1
    }
}