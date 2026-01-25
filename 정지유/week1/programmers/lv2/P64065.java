package week1.programmers.lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P64065 {
    public int[] solution(String s) {
        // {{2},{2,1},{2,1,3},{2,1,3,4}} -> 2},{2,1},{2,1,3},{2,1,3,4
        String tmp_s = s.substring(2,s.length()-2); // 규칙으로 거르기 전 {{ , }} 제거
        String[] arr = tmp_s.split("\\}\\,\\{");

        
        Arrays.sort(arr, (p1,p2) -> p1.length() - p2.length()); // 문자열 길이 기준 오름차순

        Set<String> seen = new HashSet<>(); // 증복없이 -> set
        int[] answer = new int[arr.length]; // 정답 배열에는 k 개의 원소 고정
        int idx = 0 ; // 이번에 기록할 정답 배열 인덱스

        for(String chunk : arr){ // chunk == 한 집합의 문자열 표기
            String[] numbers = chunk.split(","); // 하나의 집합 원소 단위로 쪼개 표현

            for(String num : numbers ){
                if(!seen.contains(num)){ // 이전 집합에 없었던 새 원소
                    seen.add(num);
                    answer[idx++]=Integer.parseInt(num);
                    break; // 하나의 집합에는 새로운거 하나씩만 있음
                }
            }
        }



        return answer;
    }

    // 로컬 테스트를 위한 main 함수 (프로그래머스 제출 시 제외 가능, 포함해도 무방)
    public static void main(String[] args) {
        P64065 s = new P64065();

        // [기본 테스트 케이스]
        System.out.println(Arrays.toString(s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        // Expected: [2, 1, 3, 4]

        System.out.println(Arrays.toString(s.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        // Expected: [2, 1, 3, 4] (순서 섞여 있어도 길이 정렬로 해결됨)

        System.out.println(Arrays.toString(s.solution("{{20,111},{111}}")));
        // Expected: [111, 20]

        System.out.println(Arrays.toString(s.solution("{{123}}")));
        // Expected: [123]

        System.out.println(Arrays.toString(s.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
        // Expected: [3, 2, 4, 1]

        // [엣지 케이스 추가]
        // 1. 원소 숫자가 클 때 (문제 제한: 100,000 이하 자연수)
        System.out.println(Arrays.toString(s.solution("{{100000}}")));

        // 2. 순서가 완전히 거꾸로 들어올 때
        System.out.println(Arrays.toString(s.solution("{{1,2,3},{1,2},{1}}")));
    }
}
