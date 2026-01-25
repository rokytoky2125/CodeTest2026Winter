package week2.boj.p9663;


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int count = 0;
    static int[] cols; // 각 row 의 queen 의 col 위치

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        cols = new int[N];

        solve();

        System.out.println(sb.toString());
    }



    static void solve() {
        dfs(0); // 0번 행부터
        sb.append(count);
    }


    // Type B
    static void dfs(int row) {

        // 기저 조건
        if (row == N) {
            count++;
            return;
        }

        // 2. 현재 행(row)에서 가능한 모든 열(col) 탐색
        for (int col = 0; col < N; col++) {

            boolean isPossible = true;
            for (int i = 0; i < row; i++) {

                if (cols[i] == col || Math.abs(row - i) == Math.abs(col - cols[i])) { // 세로 & 대각선 체크
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                // 체크인
                cols[row] = col;

                dfs(row + 1);

                // 체크아웃 불필요 : 1차원 배열을 덮어씌우는 구조이므로 별도의 복구 작업 불필요
            }
        }
    }

}