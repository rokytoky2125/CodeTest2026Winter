package week1.programmers.lv2;

import java.util.*;

public class P42587 {
    static class Process {
        int priority; // 가중치
        int location;  // 프로세스 식별자

        Process(int priority, int location){
            this.priority=priority;
            this.location=location;
        }
    }

    public int solution(int[] priorities, int location) {

        Deque<Process> queue = new ArrayDeque<>(); // 순서 유지 위한 원형큐

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최댓값 기준 우선순위 큐

        for(int i = 0 ; i <priorities.length;i++){
            queue.offerLast(new Process(priorities[i],i));
            pq.offer(priorities[i]);
        }

        int answer = 0 ;

        while(!queue.isEmpty()){
            Process cur = queue.pollFirst();

            if (cur.priority == pq.peek()){ // 이번 프로세스가 타겟 가중치면 제거
                pq.poll();
                answer++;

                if(cur.location == location) return answer;
            }
            else queue.offerLast(cur); // 원형 큐처럼 다시 넣음

            }
        return -1;
    }

    // 로컬 테스트를 위한 main 함수 (제출 시 복사 X)
    public static void main(String[] args) {
        P42587 s = new P42587();

        // 테스트 케이스 1
        int[] p1 = {2, 1, 3, 2};
        int l1 = 2;
        System.out.println("Test 1: " + s.solution(p1, l1)); // Expected: 1

        // 테스트 케이스 2
        int[] p2 = {1, 1, 9, 1, 1, 1};
        int l2 = 0;
        System.out.println("Test 2: " + s.solution(p2, l2)); // Expected: 5

        // 엣지 케이스: 모든 우선순위가 같을 때
        int[] p3 = {5, 5, 5, 5};
        int l3 = 3;
        System.out.println("Test 3: " + s.solution(p3, l3)); // Expected: 4
    }
}
