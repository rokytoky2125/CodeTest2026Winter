package week4.boj.p1806;


import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int S;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(sb.toString());
    }

    static void solve() {

        // 1. 초기화
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        // 2. loop
        while (true) {
            // 조건 만족 : 좀 더 빡센 범위
            if (sum >= S) {
                minLength = Math.min(minLength, end - start);
                sum -= arr[start++];
            }

            // 끝까지
            else if (end == N) break;

            // 조건 불충족
            else sum += arr[end++];

        }

        // 3. 결과 처리: 만약 minLength가 갱신되지 않았다면 0 출력
        if (minLength == Integer.MAX_VALUE) sb.append(0);
        else  sb.append(minLength);

    }
}