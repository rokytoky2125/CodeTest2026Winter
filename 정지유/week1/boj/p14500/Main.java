package week1.boj.p14500;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder() ;
    static StringTokenizer st;

    // dfs 유형 상관 없는 전역 설정
    static int[][] map;
    static boolean[][] visited;
    static int maxSum = 0;
    static int N;
    static int M;

    // 방행벡터(row, col) : 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        // 맵 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        System.out.println(sb.toString());

    }

    static void solve() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                visited[r][c] = true;
                dfs(r, c, 1, map[r][c]);
                visited[r][c] = false;

                checkExceptionShape(r, c);
            }
        }
        sb.append(maxSum).append('\n');
    }

    // 한 붓 그리기 가능한 테트로미노 처리 : 현위치 keep moving + 재귀
    static void dfs(int r, int c, int depth, int sum) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int cur_r = r + dr[i];
            int cur_c = c + dc[i];

            if (cur_r >= 0 && cur_r < N && cur_c >= 0 && cur_c < M) {
                if (!visited[cur_r][cur_c]) {
                    visited[cur_r][cur_c] = true;
                    dfs(cur_r, cur_c, depth + 1, sum + map[cur_r][cur_c]);
                    visited[cur_r][cur_c] = false;
                }
            }
        }
    }

    // 'ㅜ' 모양 처리 : 현위치 stay + 주변 조회
    static void checkExceptionShape(int r, int c) {
        int sum = map[r][c];
        int wings = 0; // 유효한 날개 갯수
        int minWing = Integer.MAX_VALUE; // 4개 다 유효할 때 제일 작은 걸 버리기 위해 기록

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 중심 유지하며 조회만 수행
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                wings++;
                sum += map[nr][nc];
                minWing = Math.min(minWing, map[nr][nc]);
            }
        }

        if (wings == 4) { // + 모양
            sum -= minWing;
            maxSum = Math.max(maxSum, sum);
        } else if (wings == 3) { // ㅗ 모양
            maxSum = Math.max(maxSum, sum);
        }
    }
}