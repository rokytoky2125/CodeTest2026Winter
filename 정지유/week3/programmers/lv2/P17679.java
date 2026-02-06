package week3.boj.programmers.lv2;

public class P17679 {

    static int R, C;
    static char[][] map;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        R = m;
        C = n;
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            // visited : 플로우 단위로 새로 갈아치움
            boolean[][] visited = new boolean[R][C];
            boolean hasRemoved = false;

            // 탐색 : 처리(삭제)할 덩어리 마킹
            for (int r = 0; r < R - 1; r++) {
                for (int c = 0; c < C - 1; c++) {
                    char target = map[r][c];

                    // 빈칸이 아니고, 현재 위치 기준 우, 하, 우하단이 모두 같은 문자인지 확인
                    if (target != ' ' && // ' ' : 임의로 내가 부여하는 빈칸 표기
                            map[r][c+1] == target &&
                            map[r+1][c] == target &&
                            map[r+1][c+1] == target) {

                        visited[r][c] = true;
                        visited[r][c+1] = true;
                        visited[r+1][c] = true;
                        visited[r+1][c+1] = true;
                        hasRemoved = true;
                    }
                }
            }

            // 더 이상 지울 블록이 없으면 루프 탈출
            if (!hasRemoved) break;

            // 처리(삭제)할 덩어리 처리 수행
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (visited[r][c]) {
                        map[r][c] = ' ';
                        answer++;
                    }
                }
            }

            // 떨어지기
            // COL 단위로 아래 -> 위 순회
            for (int c = 0; c < C; c++) {
                for (int r = R - 1; r > 0; r--) {
                    if (map[r][c] == ' ') {
                        for (int nr = r - 1; nr >= 0; nr--) {
                            if (map[nr][c] != ' ') {
                                map[r][c] = map[nr][c];
                                map[nr][c] = ' ';
                                break; // 실제 블록 하나라도 drop 성공시
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        P17679 s = new P17679();

        // 테스트 케이스 1
        String[] b1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(s.solution(4, 5, b1)); // Expected: 14

        // 테스트 케이스 2
        String[] b2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(s.solution(6, 6, b2)); // Expected: 15
    }

}
