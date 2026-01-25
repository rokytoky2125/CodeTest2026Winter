package week1.programmers.lv2;


import java.util.*;

class P42747 {
    public int solution(int[] citations) {
        // 오름차순 정렬
        Arrays.sort(citations);

        int n = citations.length;

        // h : '자신을 포함하여 뒤에 있는 논문의 개수'
        for (int i = 0; i < n; i++) {
            int h = n - i; // 현재 논문 포함, 인용 횟수가 더 많은 논문의 수

            // 오름차순이므로 citations[i]가 h 이상이면, 그 뒤에 있는 모든 논문(h개)도 당연히 h번 이상 인용된 것
            if (citations[i] >= h) return h;

        }

        return 0;
    }

    // 로컬 테스트를 위한 main 함수 (제출 시 복사 X)
    public static void main(String[] args) {
        P42747 s = new P42747();

        // 테스트 케이스 1 (문제 예시)
        // Expected: 3
        System.out.println("Test 1: " + s.solution(new int[]{3, 0, 6, 1, 5}));

        // 테스트 케이스 2 (엣지 케이스: 모두 0인 경우)
        // Expected: 0
        System.out.println("Test 2: " + s.solution(new int[]{0, 0, 0}));

        // 테스트 케이스 3 (엣지 케이스: 논문 수보다 인용 횟수가 훨씬 많은 경우)
        // 논문 2개, 둘 다 100번 인용 -> h는 논문 수인 2가 최대
        // Expected: 2
        System.out.println("Test 3: " + s.solution(new int[]{100, 100}));

        // 테스트 케이스 4 (엣지 케이스: 하나만 있는 경우)
        // Expected: 1
        System.out.println("Test 4: " + s.solution(new int[]{10}));
    }
}