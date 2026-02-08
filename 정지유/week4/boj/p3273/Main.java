package week4.boj.p3273;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int n,x;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());

        solve();

        System.out.println(sb.toString());
    }

    // 투포인터 Type B
    static void solve() {

        // 0. 정렬 필수
        Arrays.sort(arr);

        // 1. 초기화
        int count = 0;
        int start = 0;
        int end = n - 1; // 끝

        // 2. loop : 교차할때까지
        while (start < end) {

            int sum = arr[start] + arr[end];

            // 조건 만족 : 답 반영 + 양쪽 이동
            if (sum == x) {
                count++; // 답 반영
                start++;
                end--;
            }

            // 조건 초과 : 키우기
            else if (sum < x) start++;

            // 조건 미만 : 줄이기
            else end--;

        }

        sb.append(count);
    }
}