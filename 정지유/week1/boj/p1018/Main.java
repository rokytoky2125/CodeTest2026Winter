package week1.boj.p1018;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        solve(N, M);

        System.out.println(sb.toString());
    }

    static void solve(int n, int m) throws IOException {
        boolean[][] board = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'W')   board[i][j] = true;  // W면 true, B면 false
            }
        }

        int minCount = 64;

        // 체스판의 시작점 탐색
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {

                int cnt = 0; // 첫 칸을 기준으로 칠하는 비용
                boolean isWhite = board[i][j];

                // 8x8 영역 검사
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        // 예상되는 색과 다르면
                        if (board[i + x][j + y] != isWhite)  cnt++;

                        isWhite = !isWhite; // 다음 칸
                    }

                    isWhite = !isWhite; // 줄이 바뀔 때
                }

                // 64 - count : 첫 칸의 색을 반대로 칠했을 때의 비용
                cnt = Math.min(cnt, 64 - cnt);
                minCount = Math.min(minCount, cnt);
            }
        }

        sb.append(minCount);
    }
}