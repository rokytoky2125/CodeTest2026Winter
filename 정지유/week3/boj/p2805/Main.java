package week3.boj.p2805;


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static long M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        solve();

        System.out.println(sb.toString());
    }

    static void solve()  throws IOException{
        int maxH = 0;
        st = new StringTokenizer(br.readLine());
        trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > maxH) maxH = trees[i]; // input 받는 김에 최댓값도 get
        }

        binary_search(maxH);

    }

    static void binary_search(int maxH) {
        long min_boundary = 0;
        long max_boundary = maxH;
        long result = 0;

        while (min_boundary <= max_boundary) {
            long mid = (min_boundary + max_boundary) / 2;

            if (check(mid)) {
                result = mid; // 일단 정답 후보로 저장
                min_boundary = mid + 1;
            } else {
                max_boundary = mid - 1;
            }
        }
        sb.append(result);
    }


    // 중간기준 대상 조건 만족 여부 검사 : 적어도 M미터 이상을 가져갈 수 있는가?
    static boolean check(long height) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > height) {
                sum += (tree - height);
            }
        }
        return sum >= M;
    }
}