package week7.boj.p25187;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] parent;
    static int[] score;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        if (!st.hasMoreTokens()) return;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        score = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            score[i] = Integer.parseInt(st.nextToken()) == 1 ? 1 : -1;
        }

        solve(M, Q);

        System.out.print(sb);
    }

    static void solve(int m, int q) throws IOException {
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        for (int i = 0; i < q; i++) {
            int k = Integer.parseInt(br.readLine());
            if (score[find(k)] > 0) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
    }


    static int find(int x) {
        if (parent[x] == x) return x;
        // 경로 압축
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // 합치기
            parent[rootY] = rootX;
            // 그룹의 점수 총합 루트 노드에 갱신
            score[rootX] += score[rootY];
        }
    }
}