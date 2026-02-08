package week4.boj.p11053;


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(sb.toString());
    }

    // Bottom-Up
    static void solve( ) throws IOException {
        // 1. DP 테이블 생성
        // dp[i] : i번째 숫자(arr[i])를 마지막 원소로 반드시 포함하는 가장 긴 증가하는 부분 수열의 길이
        int[] dp = new int[N];

        // 2. 초기화 (자동 0 set)

        int maxLen = 1;

        // 3. 점화식 루프 진행
        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 자기 자신만으로 이루어진 수열의 길이는 1

            for (int j = 0; j < i; j++) {
                // 이전 값(j)이 현재 값(i)보다 작아야 함
                if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1); // 이전 원소 뒤에 붙이는 것이 더 긴지 확인
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        sb.append(maxLen);
    }
}