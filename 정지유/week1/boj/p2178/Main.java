package week1.boj.p2178;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] map;
    static boolean[][] visited;
    static int N, M;

    // 방향 벡터 (상, 하, 좌, 우)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        solve();

        System.out.println(sb.toString());
    }


    static void solve() throws IOException{
        int result = bfs(0, 0);
        sb.append(result);
    }

    static class Node {
        int r, c;
        int dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }


    // 1:1 타겟팅
    static int bfs(int r, int c) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(r, c, 1)); // 시작 노드 삽입
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Node curr = q.pollFirst();

            // 기저 조건
            if (curr.r == N - 1 && curr.c == M - 1)  return curr.dist;

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) { // 디폴트
                    if (!visited[nr][nc] && map[nr][nc] == 1) { // 문제 요구
                        visited[nr][nc] = true;
                        q.offerLast(new Node(nr, nc, curr.dist + 1));
                    }
                }
            }
        }
        return -1; // 도달 불가
    }
}
