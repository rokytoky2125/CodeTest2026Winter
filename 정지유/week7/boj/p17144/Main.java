package week7.boj.p17144;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int R, C, T;
    static int[][] map;
    static int cleanerTop = -1;
    static int cleanerBottom = -1;

    // 상, 우, 하, 좌 (시계 방향 기준)
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == -1) {
                    if (cleanerTop == -1) cleanerTop = r;
                    else cleanerBottom = r;
                }
            }
        }

        solve();

        System.out.println(sb.toString());
    }

    static void solve() {
        while (T-- > 0) {

            // 1. 미세먼지 확산 (방향 무관하게 4방향 탐색)
            int[][] temp = new int[R][C];
            temp[cleanerTop][0] = -1;
            temp[cleanerBottom][0] = -1;

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] > 0) {
                        int amount = map[r][c] / 5;
                        int spreadCount = 0;

                        for (int i = 0; i < 4; i++) {
                            int nr = r + dr[i];
                            int nc = c + dc[i];

                            if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
                                temp[nr][nc] += amount;
                                spreadCount++;
                            }
                        }
                        temp[r][c] += map[r][c] - (amount * spreadCount);
                    }
                }
            }
            map = temp;

            // 2. 공기청정기 작동

            // 위쪽 공기청정기 (당기는 방향: 상 -> 우 -> 하 -> 좌)
            int r = cleanerTop - 1;
            int c = 0;
            int dir = 0; // 상(0)부터 시작
            int count = 0;

            while (count < 4) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                // 경계 이탈 시 방향을 시계 방향(+1)으로 전환
                if (nr < 0 || nr > cleanerTop || nc < 0 || nc >= C) {
                    dir = (dir + 1) % 4;
                    count++;
                    continue;
                }
                if (map[nr][nc] == -1) {
                    map[r][c] = 0;
                    break;
                }
                map[r][c] = map[nr][nc];
                r = nr;
                c = nc;
            }

            // 아래쪽 공기청정기 (당기는 방향: 하 -> 우 -> 상 -> 좌)
            r = cleanerBottom + 1;
            c = 0;
            dir = 2; // 하(2)부터 시작
            count = 0;

            while (count < 4) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                // 경계 이탈 시 방향을 반시계 방향(+3)으로 전환
                if (nr < cleanerBottom || nr >= R || nc < 0 || nc >= C) {
                    dir = (dir + 3) % 4;
                    count++;
                    continue;
                }
                if (map[nr][nc] == -1) {
                    map[r][c] = 0;
                    break;
                }
                map[r][c] = map[nr][nc];
                r = nr;
                c = nc;
            }
        }

        // 3. 남은 미세먼지 계산
        int totalDust = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > 0) totalDust += map[r][c];
            }
        }
        sb.append(totalDust).append('\n');
    }
}