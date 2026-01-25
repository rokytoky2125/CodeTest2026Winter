package week1.programmers.lv2;

import java.util.*;

class P42839 {

    static HashSet<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        // 초기화
        numberSet.clear();

        // 모든 조합 만들기
        dfs("", numbers);

        // 소수 개수 세기
        int cnt = 0;
        for (int num : numberSet) {
            if (num < 2) continue; //  0과 1
            boolean isPrime = true;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) cnt++;
        }

        return cnt;
    }


    public void dfs(String current, String remaining) {
        // 현재 조합된 숫자가 있다면 Set에 추가
        if (!current.equals("")) numberSet.add(Integer.valueOf(current));

        // 남은 숫자 카드로 다음 조합 생성
        for (int i = 0; i < remaining.length(); i++) {
            dfs(current + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1));
        }
    }

    // 로컬 테스트를 위한 main 함수 (제출 시 복사 X)
    public static void main(String[] args) {
        P42839 s = new P42839();

        // 테스트 케이스 1
        System.out.println(s.solution("17")); // Expected: 3 ([7, 17, 71])

        // 테스트 케이스 2
        System.out.println(s.solution("011")); // Expected: 2 ([11, 101])

        // 엣지 케이스
        System.out.println(s.solution("0")); // Expected: 0
        System.out.println(s.solution("2")); // Expected: 1
    }
}