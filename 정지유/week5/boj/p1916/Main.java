package week5.boj.p1916;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static ArrayList<ArrayList<Node>> graph;
    static long[] dist;
    static final long INF = Long.MAX_VALUE / 2;

    static class Node {
        int idx;
        long cost;

        public Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        solve(start, end);

        System.out.println(sb.toString());
    }

    static void solve(int start, int end) {
        dijkstra(start);
        sb.append(dist[end]);
    }

    // 1:1
    static void dijkstra(int start) {
        // 큐 여기서 생성
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));

        // 시작점 처리
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        // 큐가 빌 때까지 반복
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // 가지치기
            if (dist[curr.idx] < curr.cost) continue;

            // 인접 노드 탐색
            for (Node next : graph.get(curr.idx)) {
                long nextCost = dist[curr.idx] + next.cost;

                if (dist[next.idx] > nextCost) { // 문제 조건
                    dist[next.idx] = nextCost;
                    pq.offer(new Node(next.idx, nextCost));
                }
            }
        }
    }
}