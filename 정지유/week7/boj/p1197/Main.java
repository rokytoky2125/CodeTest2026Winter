package week7.boj.p1197;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] parent;

    static class Edge {
        int u, v, weight;
        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        solve(V, E);
    }

    static void solve(int v, int e) throws IOException {
        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        // 1. 가중치 기준 오름차순 정렬
        Arrays.sort(edges, (e1, e2) -> Integer.compare(e1.weight, e2.weight));

        long totalWeight = 0;
        int connectedEdges = 0;

        // 2. 간선 순회하며 MST 구축
        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                totalWeight += edge.weight;
                connectedEdges++;
                if (connectedEdges == v - 1) break;
            }
        }

        System.out.println(totalWeight);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) parent[rootY] = rootX;
    }
}