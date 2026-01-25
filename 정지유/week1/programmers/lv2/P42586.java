package week1.programmers.lv2;

import java.util.*;

public class P42586 {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] tmpAnswer = new int[100]; // max 사이즈로 잡기 : 배열은 불변
        int idx = 0 ;

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0 ; i <progresses.length ; i++){
            // 현재 작업이 단독 몇 일 걸리는가
            // 1 % == 1 일
            int days = (int) Math.ceil( (100.0 - progresses[i]) / speeds[i] );
            queue.offerLast(days);
        }

        if(!queue.isEmpty()){ // 큐에 뭔가 있디 == 이전 작업 있다

            int preDay = queue.pollFirst(); // 가장 앞에 있는 작업: 무조건 배포 대상
            int count = 1; // 가장 앞 작업 건

            while(!queue.isEmpty()){
                // 가장 앞에 있던 작업 바로 다음 작업이 같이 처리 가능한 작업인가
                if(queue.peekFirst( ) <= preDay){  // 같이 처리 가능하면 같이 처리
                    queue.pollFirst();
                    count++;
                }
                else{ // 같이 처리할 거 다 모았으면 ( 이후 작업들이 같이 처리 불가한 작업들이면 )
                    tmpAnswer[idx++] = count; // 지금까지 모은 작업들 저장

                    preDay = queue.pollFirst(); // 시작 기준 작업 초기화
                    count = 1; // 카운트 초기화
                }
            }

            tmpAnswer[idx++] = count; // 떨이 처리

        }

        return Arrays.copyOf(tmpAnswer, idx);
    }


    // 로컬 테스트를 위한 main 함수 (제출 시 복사 X)
    public static void main(String[] args) {
        P42586 s = new P42586();

        // 테스트 케이스 1
        int[] p1 = {93, 30, 55};
        int[] s1 = {1, 30, 5};
        System.out.println("Test 1: " + Arrays.toString(s.solution(p1, s1)));
        // Expected: [2, 1]

        // 테스트 케이스 2
        int[] p2 = {95, 90, 99, 99, 80, 99};
        int[] s2 = {1, 1, 1, 1, 1, 1};
        System.out.println("Test 2: " + Arrays.toString(s.solution(p2, s2)));
        // Expected: [1, 3, 2]
    }
}
