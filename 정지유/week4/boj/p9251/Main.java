package week4.boj.p9251;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String s1 = br.readLine();
        String s2 = br.readLine();

        solve(s1, s2);

        System.out.println(sb.toString());
    }

    // Bottom-Up
    static void solve(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // 1. DP 테이블 생성
        // dp[i][j] : 첫 번째 문자열의 i번째 글자까지와, 두 번째 문자열의 j번째 글자까지 잘라서 보았을 때의 LCS 길이
        int[][] dp = new int[n + 1][m + 1];

        // 2. 초기화 생략 (자동)

        // 3. 점화식으로 테이블 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 문자가 같으면
                if (s1.charAt(i - 1) == s2.charAt(j - 1))  dp[i][j] = dp[i - 1][j - 1] + 1;
                // 문자가 다르면
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //누적된 최댓값 유지

            }
        }

        sb.append(dp[n][m]);
    }
}