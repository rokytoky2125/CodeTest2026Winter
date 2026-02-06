package week3.boj.p1654;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static long[] cables;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        cables = new long[K];

        solve();

        System.out.println(sb.toString());
    }

    static void solve() throws IOException{
        long max_length = 0;
        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine());
            if (max_length < cables[i]) max_length = cables[i]; // input 한줄씩 받는 김에 최대 길이도 구함
        }

        binary_search(max_length);

    }

    // 이분탐색(매개변수 탐색)
    static void binary_search(long max_length) {
        long min_boundary = 1; // 0아닌 1부터
        long max_boundary = max_length;
        long result = 0;

        while (min_boundary <= max_boundary) {
            long mid = (min_boundary + max_boundary) / 2;

            // mid 따른 범위 조정
            if (check(mid)) {
                result = mid;
                min_boundary = mid + 1;
            } else {
                max_boundary = mid - 1;
            }
        }
        sb.append(result);
    }

    // mid 길이 기준 조건 충족 여부 확인: N개 이상 만들 수 있나
    static boolean check(long mid) {
        long count = 0;
        for (long cable : cables) {
            count += (cable / mid); // mid 길이의 케이블이 몇 개 만들어지나
        }
        return count >= N ;
    }
}