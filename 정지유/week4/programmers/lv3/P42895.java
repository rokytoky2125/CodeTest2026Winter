package week4.programmers.lv3;

import java.util.*;

class P42895 {

    public int solution(int N, int number) {
        // 엣지 케이스
        if (N == number) return 1;

        // 1. DP 배열 정의
        Set<Integer>[] dp = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            dp[i] = new HashSet<>();
        }

        // 2. 초기값 및 점화식 수행 (Bottom-up)
        for (int i = 1; i <= 8; i++) {

            // A. 단순 연결된 숫자 추가 (5, 55, 555 ...)
            int repeatedNumber = N;
            for (int k = 1; k < i; k++) {
                repeatedNumber = repeatedNumber * 10 + N;
            }
            dp[i].add(repeatedNumber);

            // B. 사칙연산 조합
            for (int j = 1; j < i; j++) {// j: 첫 번째 피연산자가 사용한 N의 횟수
                for (int num1 : dp[j]) {
                    for (int num2 : dp[i - j]) {// i-j: 두 번째 피연산자가 사용한 N의 횟수
                        dp[i].add(num1 + num2);
                        dp[i].add(num1 - num2);
                        dp[i].add(num1 * num2);
                        if (num2 != 0) {
                            dp[i].add(num1 / num2);
                        }
                    }
                }
            }

            if (dp[i].contains(number)) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        P42895 s = new P42895();

        // 테스트 케이스
        System.out.println("Test 1: " + s.solution(5, 12)); // Expected: 4
        System.out.println("Test 2: " + s.solution(2, 11)); // Expected: 3
        System.out.println("Edge 1: " + s.solution(5, 5));  // Expected: 1
    }
}