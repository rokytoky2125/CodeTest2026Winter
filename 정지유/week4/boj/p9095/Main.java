package week4.boj.p9095;


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i <T;i++) {
            int n = Integer.parseInt(br.readLine());
            solve(n);
        }

        System.out.println(sb.toString());
    }

    //  Bottom-Up
    static void solve(int n) {
        // 1. DP 테이블 생성
        // DP[i] : 정수 i 를 1,2,3 의 합으로 나타내는 경우의 수
        int[] dp = new int[11];

        // 2. 초기값 설정
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 3. 점화식으로 테이블 채우기 (Loop)
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        sb.append(dp[n]).append('\n');
    }
}