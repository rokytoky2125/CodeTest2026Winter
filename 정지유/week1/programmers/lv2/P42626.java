package week1.programmers.lv2;

import java.util.*;


public class P42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 우선순위 큐(최소힙) 초기화
        for(int s :scoville){
            pq.offer(s);
        }

        // 허프만
        while( pq.peek() < K ){

            if(pq.size()<2) return -1; // 다 섞어도 K 미만이면

            // 최솟값 2개 poll
            int food1 = pq.poll();
            int food2 = pq.poll();

            int jjambbong = food1 + (food2*2);

            // 뽑은 2개의 값 뭉친 하나의 결과 다시 offer
            pq.offer(jjambbong);

            answer++;
        }


        return answer;
    }

    // 로컬 테스트를 위한 main 함수 (제출 시 복사 X)
    public static void main(String[] args) {
        P42626 s = new P42626();

        // 테스트 케이스 1
        int[] scoville1 = {1, 2, 3, 9, 10, 12};
        int K1 = 7;
        int result = s.solution(scoville1, K1);
        System.out.println("Result: " + result); // Expected: 2

        // 테스트 케이스 2
        int[] scoville2 = {10, 12, 15};
        int K2 = 7;
        System.out.println("Result2: " + s.solution(scoville2, K2)); // Expected: 0

        // 테스트 케이스 3
        int[] scoville3 = {1, 2};
        int K3 = 100;
        System.out.println("Result3: " + s.solution(scoville3, K3)); // Expected: -1
    }

}
