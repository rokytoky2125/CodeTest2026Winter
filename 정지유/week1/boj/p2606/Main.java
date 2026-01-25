package week1.boj.p2606;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M;
    static int virusCount = 0; // 감염된 컴퓨터 수

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 네트워크 -> 양방향
            graph[u].add(v);
            graph[v].add(u);
        }

        solve(N, M);

        System.out.println(sb.toString());
    }

    static void solve(int n, int m) {
        dfs(1);
        sb.append(virusCount - 1); // 1번(본인) 제외
    }

    // 땅따먹기
    static void dfs(int start) {
        // 입장 즉시 처리
        visited[start] = true;
        virusCount++;

        // 연결된 노드 탐색
        for (int next : graph[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}