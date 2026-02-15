package week5.programmers.lv2;


import java.util.*;

class P12978 {

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

    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        for (int[] r : road) {
            int u = r[0];
            int v = r[1];
            int w = r[2];

            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        dijkstra(1);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                count++;
            }
        }
        return count;
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

                long nextCost = dist[curr.idx] + next.cost; // 비용 계산

                if (dist[next.idx] > nextCost) { // 문제 조건
                    dist[next.idx] = nextCost;
                    pq.offer(new Node(next.idx, nextCost));
                }
            }
        }
    }

    public static void main(String[] args) {
        P12978 s = new P12978();

        // 테스트 케이스 1
        int N1 = 5;
        int[][] road1 = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int K1 = 3;
        System.out.println(s.solution(N1, road1, K1)); // Expected: 4

        // 테스트 케이스 2
        int N2 = 6;
        int[][] road2 = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int K2 = 4;
        System.out.println(s.solution(N2, road2, K2)); // Expected: 4
    }
}