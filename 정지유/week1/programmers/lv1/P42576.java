package week1.programmers.lv1;


import java.util.*;

public class P42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> participant_map = new HashMap<>();


        // 참가자 등록
        for(String target : participant){
            int cur_target_cnt = participant_map.getOrDefault(target,0)+1;
            participant_map.put(target,cur_target_cnt);
        }

        // 완주자 감소
        for(String target : completion){
            int cur_target_cnt = participant_map.get(target)-1;
            participant_map.put(target,cur_target_cnt);
        }

        // map 은 Map.Entry 활용 Iterable st 조회
        for(Map.Entry<String,Integer> e: participant_map.entrySet()){

            if (e.getValue()>0){
                answer = e.getKey();
                break; // 한 명 찾음 걍 끝
            }



        }


        return answer;
    }

    // 로컬 테스트를 위한 main 함수 (제출할 땐 복사 X)
    public static void main(String[] args) {
        P42576 s = new P42576();

        // Test Case 1
        String[] p1 = {"leo", "kiki", "eden"};
        String[] c1 = {"eden", "kiki"};
        System.out.println("TC1: " + s.solution(p1, c1)); // Expected: "leo"

        // Test Case 2
        String[] p2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] c2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println("TC2: " + s.solution(p2, c2)); // Expected: "vinko"

        // Test Case 3 (동명이인 케이스)
        String[] p3 = {"mislav", "stanko", "mislav", "ana"};
        String[] c3 = {"stanko", "ana", "mislav"};
        System.out.println("TC3: " + s.solution(p3, c3)); // Expected: "mislav"
    }
}