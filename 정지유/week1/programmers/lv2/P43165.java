package week1.programmers.lv2;

import java.util.*;

class P43165 {
    int count = 0;
    // 별도의 visited 배열은 필요 없음 : 물리적으로 뒤로 못가는 구조임

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }

    // 백트래킹
    public void dfs(int[] numbers, int target, int depth, int sum) {

        // 기저조건
        if (depth == numbers.length) {
            if (sum == target) count++;
            return;
        }

        // 더하는 || 빼는 경우
        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }


    public static void main(String[] args) {
        P43165 s = new P43165();

        // 테스트 케이스 1
        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        System.out.println("Test Case 1: " + s.solution(numbers1, target1));
        // Expected: 5

        // 테스트 케이스 2
        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;
        System.out.println("Test Case 2: " + s.solution(numbers2, target2));
        // Expected: 2

    }
}