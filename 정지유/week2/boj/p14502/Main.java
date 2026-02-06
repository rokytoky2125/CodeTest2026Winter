package week2.boj.p14502;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int R, C;
    static int[][] map;
    static boolean[][] vDFS; // 전역 참조를 위한 dfs 전용 visited 배열

    // 방향 벡터 : 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int maxSafeArea = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        vDFS = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        System.out.println(sb.toString());
    }

    static void solve() {
        dfs(0,0,0);
        sb.append(maxSafeArea);
    }

    // DFS Type B - 조합 기반 (중복 조합 제거)
    static void dfs(int startR, int startC, int depth) {
        // 기저조건
        if (depth == 3) {
            // 각 dfs 케이스마다 bfs 돌려보기
            // bfs 실행 위한 초기 세팅
            ArrayDeque<Node> q = new ArrayDeque<>();
            boolean[][] vBFS = new boolean[R][C];

            // k 개의 시작점 초기화
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 2) {
                        q.offerLast(new Node(i, j));
                        vBFS[i][j] = true;
                    }
                }
            }

            // bfs 수행
            bfs(q,vBFS);

            return;
        }

        // 뇌 필요한 뤂제어변수 관리
        for (int i = startR ; i < R; i++) {
            int tunedC = (i==startR) ? startC : 0;
            for (int j = tunedC; j < C; j++) {
                // 중복 조합 제거 ver : 디폴트 조건식 불필요
                if (map[i][j] == 0 && !vDFS[i][j]) { // 문제조건식
                    vDFS[i][j] = true;  // 체크인
                    dfs(i, j + 1, depth + 1);
                    vDFS[i][j] = false; // 체크아웃
                }            }
        }
    }




    // BFS Type B (N:M 동시 확산)
    static void bfs(ArrayDeque<Node> q, boolean[][] vBFS ){

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    // map 원본 빈공간 && DFS로 벽 안쌓은 곳 && 바이러스가 아직 안 퍼진 곳
                    if (map[nr][nc] == 0 && !vDFS[nr][nc] && !vBFS[nr][nc]) {
                        vBFS[nr][nc] = true; // 바이러스 전파 (방문 처리)
                        q.offer(new Node(nr, nc));
                    }
                }
            }
        }

        //  안전 영역 계산
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 바이러스가 도달하지 못한 빈공간
                if (map[i][j] == 0 && !vDFS[i][j] && !vBFS[i][j]) {
                    count++;
                }
            }
        }

        // 최댓값 갱신
        maxSafeArea = Math.max(maxSafeArea, count);



    }



}