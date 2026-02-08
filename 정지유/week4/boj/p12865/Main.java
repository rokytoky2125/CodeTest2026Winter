package week4.boj.p12865;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N,K;
    static int[] W , V;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N + 1]; // 무게 배열
        V = new int[N + 1]; // 가치 배열

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(sb.toString());
    }

    // Bottom-up
    static void solve() throws IOException {

        // 1. DP 테이블 생성
        // dp[i][j] : i번째 물건까지 고려하고, 배낭 용량이 j일 때의 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        // 2. 초기값 설정 (자동 0 설정)

        // 3. 점화식으로 테이블 채우기 (Bottom-up Loop)
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                // 못 넣음
                if (W[i] > w)  dp[i][w] = dp[i - 1][w]; // 전단계 값 그대로
                // 넣음
                else dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - W[i]] + V[i]);
            }
        }

        sb.append(dp[N][K]);
    }
}