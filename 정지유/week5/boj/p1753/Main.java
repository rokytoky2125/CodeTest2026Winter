package week5.boj.p1753;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int V, E, K;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        solve();

        System.out.println(sb);
    }

    static void solve()  throws IOException  {

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }


        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF)   sb.append("INF").append('\n');
            else sb.append(dist[i]).append('\n');
        }
    }

    // 1:1
    static void dijkstra(int start) {
        // 여기서 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));

        // 시작점 처리
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        // 큐가 빌 때까지
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curV = current.v;
            int curW = current.w;

            // 가지치기
            if (dist[curV] < curW) continue;

            // 인접 노드 탐색
            for (Node next : graph[curV]) {
                int nextCost = dist[curV] + next.w;

                if (dist[next.v] > nextCost) { // 문제 조건
                    dist[next.v] = nextCost;
                    pq.offer(new Node(next.v, nextCost));
                }
            }
        }
    }
}