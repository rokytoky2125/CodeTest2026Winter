package week1.boj.p1260;

import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M, V;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        solve();

        System.out.println(sb.toString());
    }

    public static void solve() throws IOException {

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u); // 양방향
        }


        //  정점 번호 오름차순
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }


        // DFS 수행
        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');

        // BFS 수행
        visited = new boolean[N + 1]; // 방문 배열 초기화 필수
        bfs(V);

    }


    // 백트래킹x
    static void dfs(int node) {
        // 입장하자마자 방문 처리
        visited[node] = true;
        sb.append(node).append(" ");

        // 연결된 노드 탐색
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }


    static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();

        // 시작점 초기화
        q.offerLast(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.pollFirst();
            sb.append(node).append(" ");

            // 연결된 노드 탐색
            for (int next : graph[node]) {
                if (!visited[next]) { // 단순 미방문
                    visited[next] = true;
                    q.offerLast(next);
                }
            }
        }
    }


}
