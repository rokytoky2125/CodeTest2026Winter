package week1.programmers.lv2;

import java.util.*;

public class P42577 {

    public boolean solution(String[] phone_book) {
        // “해시” 카테고리에 올라가 있긴한데, ary 풀이도 대표 정답 인정
        Arrays.sort(phone_book);


        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

    // 로컬 테스트를 위한 main 함수 (제출 시 제외)
    public static void main(String[] args) {
        P42577 s = new P42577();

        // 테스트 케이스 1
        String[] case1 = {"119", "97674223", "1195524421"};
        System.out.println("Test Case 1: " + s.solution(case1)); // Expected: false

        // 테스트 케이스 2
        String[] case2 = {"123", "456", "789"};
        System.out.println("Test Case 2: " + s.solution(case2)); // Expected: true

        // 테스트 케이스 3
        String[] case3 = {"12", "123", "1235", "567", "88"};
        System.out.println("Test Case 3: " + s.solution(case3)); // Expected: false

        // 엣지 케이스 추가 테스트
        String[] edgeCase = {"123", "12345"}; // 단순 포함 관계
        System.out.println("Edge Case: " + s.solution(edgeCase)); // Expected: false
    }


}
