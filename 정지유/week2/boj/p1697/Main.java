package week2.boj.p1697;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, K;
    static boolean[] visited = new boolean[100001];

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        solve();

        System.out.println(sb.toString());

    }

    static void solve(){
        if (N == K) sb.append(0);
        else  bfs(N);
    }

    // 1:1 타겟팅
    static void bfs(int start) {
        // 큐 생성
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(start, 0));
        visited[start] = true;


        while (!q.isEmpty()) {
            Node curr = q.pollFirst();

            // 3가지 이동 경우의 수 (앞, 뒤, 순간이동)
            int[] nextMoves = {curr.x - 1, curr.x + 1, curr.x * 2};

            for (int next : nextMoves) {
                // 기저 조건
                if (next == K) {
                    sb.append(curr.time + 1);
                    return;
                }

                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    q.offerLast(new Node(next, curr.time + 1));
                }
            }
        }
    }
}