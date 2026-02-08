package week4.programmers.lv3;

import java.util.*;

class P67258 {

    // 투포인터 Type A
    public int[] solution(String[] gems) {

        // 종류 갯수 구하기
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        int targetTypeCount = gemSet.size();

        // 1. 초기화
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        // 2. loop
        while (true) {

            // 조건 만족/초과 시 : 정답 조건 확인 및 갱신 + 줄이기
            if (map.size() >= targetTypeCount) { // == 까지가 최대긴 하지만 형식 체화 차원 >=

                int currentLength = end - start;

                // 조건 만족시 정답 업뎃
                if (currentLength < minLength) {
                    minLength = currentLength;
                    answer[0] = start + 1;
                    answer[1] = end;
                }

                // 줄이기
                String out  = gems[start]; // 제거 대상 key
                if(map.get(out) == 1) map.remove(out);
                else map.put(out, map.get(out) - 1);
                start++;

            }

            // 끝까지 다 왔으면 종료
            else if (end == gems.length)  break;

            // 조건 미달 시: 늘리기
            else {
                String endGem = gems[end];
                map.put(endGem, map.getOrDefault(endGem, 0) + 1);
                end++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        P67258 s = new P67258();

        // 테스트 케이스 1
        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(s.solution(gems1)));
        // Expected: [3, 7]

        // 테스트 케이스 2
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        System.out.println(Arrays.toString(s.solution(gems2)));
        // Expected: [1, 3]

        // 테스트 케이스 3
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        System.out.println(Arrays.toString(s.solution(gems3)));
        // Expected: [1, 1]

        // 테스트 케이스 4
        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(Arrays.toString(s.solution(gems4)));
        // Expected: [1, 5]
    }
}