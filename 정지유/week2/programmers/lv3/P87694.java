package week2.programmers.lv3;

import java.util.*;

class P87694 {

    // 문제 좌표 MAX 50 -> 2배 -> 100. 여유분 포함 102
    int[][] map;
    boolean[][] visited;

    // 방향 벡터: 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r, c, dist;
        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        map = new int[102][102];
        visited = new boolean[102][102];

        // 환경 초기화
        // 모든 직사각형을 1로 채우기
        for (int[] rect : rectangle) {
            // 좌표 2배 확대
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = 1;
                }
            }
        }

        // 직사각형의 '내부'만 0으로 파내기 (=테두리만 1로 남김)
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            // 내부만 0으로 변경
            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    map[i][j] = 0;
                }
            }
        }

        // BFS 탐색
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    private int bfs(int startX, int startY, int targetX, int targetY) {
        ArrayDeque<Node> q = new ArrayDeque<>();

        q.offerLast(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node curr = q.pollFirst();

            // 기저 조건
            if (curr.r == targetX && curr.c == targetY) return curr.dist / 2; // 2배 확대했으므로 결과를 2로 나눔


            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr >= 0 && nr < 102 && nc >= 0 && nc < 102) { // ㅈㄴ 기본 조건
                    if (!visited[nr][nc] && map[nr][nc] == 1) { // 문제 조건 : 테두리 1이면
                        q.offerLast(new Node(nr, nc, curr.dist + 1));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        P87694 s = new P87694();

        // 테스트 케이스 1
        int[][] rect1 = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        System.out.println(s.solution(rect1, 1, 3, 7, 8)); // Expected: 17

        // 테스트 케이스 2
        int[][] rect2 = {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
        System.out.println(s.solution(rect2, 9, 7, 6, 1)); // Expected: 11

        // 테스트 케이스 3
        int[][] rect3 = {{1,1,5,7}};
        System.out.println(s.solution(rect3, 1, 1, 4, 7)); // Expected: 9

        // 테스트 케이스 4
        int[][] rect4 = {{2,1,7,5},{6,4,10,10}};
        System.out.println(s.solution(rect4, 3, 1, 7, 10)); // Expected: 15

        // 테스트 케이스 5
        int[][] rect5 = {{2,2,5,5},{1,3,6,4},{3,1,4,6}};
        System.out.println(s.solution(rect5, 1, 4, 6, 3)); // Expected: 10
    }
}