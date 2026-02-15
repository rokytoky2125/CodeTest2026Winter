package week5.programmers.lv3;

import java.util.*;

class P72413 {

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

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int w = fare[2];

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }


        // S 기준 최단 거리
        dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dijkstra(s);
        long[] distS = dist.clone();

        // A 기준 최단 거리 (양방향이므로 A->K는 K->A와 동일)
        Arrays.fill(dist, INF);
        dijkstra(a);
        long[] distA = dist.clone();

        // B 기준 최단 거리 (양방향이므로 B->K는 K->B와 동일)
        Arrays.fill(dist, INF);
        dijkstra(b);
        long[] distB = dist.clone();

        long minCost = INF;

        for (int i = 1; i <= n; i++) {
            // S->K + K->A + K->B 경로가 유효한 경우만 계산
            if (distS[i] != INF && distA[i] != INF && distB[i] != INF) {
                long currentCost = distS[i] + distA[i] + distB[i];
                if (minCost > currentCost) {
                    minCost = currentCost;
                }
            }
        }

        return (int) minCost;
    }

    // 1:1
    static void dijkstra(int start) {
        // 큐 여기서 생성
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));

        // 시작점 처리
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        // 큐가 빌 때까지 반복
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // 가지치기
            if (dist[curr.idx] < curr.cost) continue;

            for (Node next : graph.get(curr.idx)) {

                long nextCost = dist[curr.idx] + next.cost;

                if (dist[next.idx] > nextCost) { // 문제 조건
                    dist[next.idx] = nextCost;
                    pq.offer(new Node(next.idx, nextCost));
                }
            }
        }
    }

    public static void main(String[] args) {
        P72413 sol = new P72413();

        // 테스트 케이스 1
        int n1 = 6;
        int s1 = 4, a1 = 6, b1 = 2;
        int[][] fares1 = {
                {4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41},
                {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
        };
        System.out.println(sol.solution(n1, s1, a1, b1, fares1)); // Expected: 82

        // 테스트 케이스 2
        int n2 = 7;
        int s2 = 3, a2 = 4, b2 = 1;
        int[][] fares2 = {
                {5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}
        };
        System.out.println(sol.solution(n2, s2, a2, b2, fares2)); // Expected: 14

        // 테스트 케이스 3
        int n3 = 6;
        int s3 = 4, a3 = 5, b3 = 6;
        int[][] fares3 = {
                {2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}
        };
        System.out.println(sol.solution(n3, s3, a3, b3, fares3)); // Expected: 18
    }
}