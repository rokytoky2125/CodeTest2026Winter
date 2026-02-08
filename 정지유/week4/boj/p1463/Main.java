package week4.boj.p1463;


import java.io.*;
import java.util.*;

public class Main {
    // 빠른 입출력을 위한 객체
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        solve(N);

        System.out.print(sb.toString());
    }

    // bottom-up
    static void solve(int n) throws IOException {
        // 1. dp 테이블 생성 + 2. 초기값 설정
        int[] dp = new int[n + 1]; // dp[i] : i를 1로 만드는 최소 횟수

        // 3. 점화식으로 테이블 채우기 (Loop)
        for (int i = 2; i <= n; i++) { // 2 부터 시작 (1은 이미 1)
            // 1. 먼저 1을 빼는 경우 (i-1에서 1을 더한 횟수)
            dp[i] = dp[i - 1] + 1;

            // 2. 2로 나누어 떨어지는 경우, 기존 값과 비교하여 최솟값 갱신
            if (i % 2 == 0)  dp[i] = Math.min(dp[i], dp[i / 2] + 1);

            // 3. 3으로 나누어 떨어지는 경우, 기존 값과 비교하여 최솟값 갱신
            if (i % 3 == 0)   dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        sb.append(dp[n]).append('\n');
    }
}