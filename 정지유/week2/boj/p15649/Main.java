package week2.boj.p15649;


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] arr;       // 선택 순서 기록
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        solve();

        System.out.print(sb.toString());
    }


    static void solve() {
        arr = new int[M];
        visited = new boolean[N + 1];

        dfs(0); // 깊이 0부터
    }


    // Type B
    static void dfs(int depth) {
        // 기저 조건
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 탐색
        for (int i = 1; i <= N; i++) {

            if (!visited[i]) {
                // 체크인
                visited[i] = true;
                arr[depth] = i;

                dfs(depth + 1);

                // 체크아웃
                visited[i] = false;
            }
        }
    }
}