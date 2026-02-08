package week4.programmers.lv3;

import java.util.*;

class P42898 {

    public int solution(int m, int n, int[][] puddles) {
        int mod = 1_000_000_007;

        // 1. DP 배열 선언 (행: n, 열: m)
        // 의미: dp[i][j]는 (0,0)에서 (i,j)까지 가는 경로의 수
        int[][] dp = new int[n][m];

        // 2. 초기화
        for (int[] puddle : puddles) {
            int col = puddle[0] - 1;
            int row = puddle[1] - 1;
            dp[row][col] = -1; // -1 초기화
        }
        dp[0][0] = 1;

        // 4. 채우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 웅덩이인 경우
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                // 시작점
                if (i == 0 && j == 0) continue;

                // 위쪽에서 오는 경우
                int fromUp = 0;
                if (i > 0) fromUp = dp[i-1][j];

                // 왼쪽에서 오는 경우
                int fromLeft = 0;
                if (j > 0) fromLeft = dp[i][j-1];

                // 점화식
                dp[i][j] = (fromUp + fromLeft) % mod;
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        P42898 s = new P42898();

        // Test Case 1
        int m1 = 4;
        int n1 = 3;
        int[][] puddles1 = {{2, 2}};
        System.out.println("Test 1: " + s.solution(m1, n1, puddles1)); // Expected: 4

        // Test Case 2 (엣지 케이스: 웅덩이가 없는 경우)
        int m2 = 3;
        int n2 = 3;
        int[][] puddles2 = {};
        System.out.println("Test 2: " + s.solution(m2, n2, puddles2)); // Expected: 6

    }
}