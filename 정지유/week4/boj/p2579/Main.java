package week4.boj.p2579;


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[] scores = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        solve(N, scores);

        System.out.println(sb.toString());
    }

    // bottom-up
    static void solve(int n, int[] scores) {

        // 1. 예외 처리: 계단이 1개면 바로 리턴해야 (안그럼 dp[2] 초기화 out of index error )
        if (n == 1) {
            sb.append(scores[1]);
            return;
        }


        // 1. DP 테이블 생성
        // dp[i] : i번째 계단을 밟았을 때의 최댓값
        int[] dp = new int[n + 1];

        // 2. 초기값 설정
        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];


        // 3. 점화식으로 테이블 채우기 (Loop)
        for (int i = 3; i <= n; i++) {
            int maxVal = Math.max(dp[i - 2], dp[i - 3] + scores[i - 1]);
            dp[i] =  maxVal + scores[i];
        }

        sb.append(dp[n]);
    }
}