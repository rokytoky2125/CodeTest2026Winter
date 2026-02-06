package week3.boj.p14503;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    // 방향 벡터: 북 동 남 서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(r, c, d);

        System.out.println(sb.toString());
    }

    static void solve(int r, int c, int d) {
        while (true) {
            // 1. 현재 칸이 아직 청소되지 않은 경우
            if (!visited[r][c]) {
                visited[r][c] = true;
                ans++;
            }

            boolean existUncleaned = false;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) { // 상식 조건
                    if (map[nr][nc] == 0 && !visited[nr][nc]) { // 문제 조건
                        existUncleaned = true;
                        break;
                    }
                }
            }

            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (!existUncleaned) {
                int backD = (d + 2) % 4; // 반대 방향
                int brr = r + dr[backD];
                int bcc = c + dc[backD];

                // 주의 1 : 실질적인 처리(청소)를 위한 단순 후진을 위한 이동이기에 visited 는 검사하지 않는다.
                // 주의 2 : map 체크는 문제 조건이라고 내부 if 문에서 검사하게 하면 안된다 - 그러면 불만족해도 else 에 안걸리게 된다
                if (brr >= 0 && brr < N && bcc >= 0 && bcc < M && map[brr][bcc] == 0) {
                    r = brr;
                    c = bcc;
                } 
                else break; // 후진 불가
                
            }

            // 3. 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            else {
                d = (d + 3) % 4; // 반시계 방향회전
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) { // 상식 조건
                    if (map[nr][nc] == 0 && !visited[nr][nc]) { // 문제 조건
                        r = nr;
                        c = nc;
                    }
                }
            }
        }
        sb.append(ans);
    }
}
