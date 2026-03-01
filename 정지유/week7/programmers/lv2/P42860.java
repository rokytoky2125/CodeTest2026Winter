package week7.programmers.lv2;

import java.util.*;

class P42860 {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();

        // 1. 상하 조작 횟수 합계 계산
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 2. 좌우 이동 최소 횟수 계산
        int minMove = n - 1;

        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            int move1 = i * 2 + (n - next);

            int move2 = (n - next) * 2 + i;

            // 세 가지 시나리오 중 최솟값 갱신
            minMove = Math.min(minMove, Math.min(move1, move2));
        }

        return answer + minMove;
    }

    public static void main(String[] args) {
        P42860 sol = new P42860();

        String[] testNames = {"JEROEN", "JAN", "ABAAAAABB"};
        int[] expected = {56, 23, 7};

        for (int i = 0; i < testNames.length; i++) {
            int result = sol.solution(testNames[i]);
            System.out.printf("테스트 케이스 %d: 입력=%s, 결과=%d\n", i + 1, testNames[i], result);
        }
    }
}
