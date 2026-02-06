package week2.boj.p14888;



import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] numbers;
    static int[] operators = new int[4]; // +, -, *, / 개수
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }


        solve();
        sb.append(maxResult).append('\n').append(minResult);
        System.out.println(sb.toString());
    }



    static void solve() {
        dfs(1, numbers[0]);
    }

    // Type B
    static void dfs(int depth, int currentSum) {
        // 기저 조건
        if (depth == N) {
            maxResult = Math.max(maxResult, currentSum);
            minResult = Math.min(minResult, currentSum);

            return;
        }

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                //  체크인
                operators[i]--;

                // 연산 로직
                int nextSum = currentSum;
                if (i == 0) nextSum += numbers[depth];      // +
                else if (i == 1) nextSum -= numbers[depth]; // -
                else if (i == 2) nextSum *= numbers[depth]; // *
                else if (i == 3) nextSum /= numbers[depth]; // /

                dfs(depth + 1, nextSum);

                // 체크아웃
                operators[i]++;
            }
        }
    }
}