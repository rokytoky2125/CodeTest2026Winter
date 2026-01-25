package week1.programmers.lv1;

import java.util.*;

class P42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0 ; i<commands.length;i++){
            int cmd_i = commands[i][0];
            int cmd_j = commands[i][1];
            int cmd_k = commands[i][2];

            // 절단
            int[] sub = Arrays.copyOfRange(array,cmd_i-1,cmd_j); // 0 이 아닌 1부터 시작

            // 정렬
            Arrays.sort(sub);

            answer[i]=sub[cmd_k - 1];
        }

        return answer;
    }

    // 로컬 테스트를 위한 main 함수
    public static void main(String[] args) {
        P42748 s = new P42748();

        // 문제 예시 데이터
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        // 실행 및 결과 출력
        int[] result = s.solution(array, commands);
        System.out.println(Arrays.toString(result));
        // Expected: [5, 6, 3]
    }
}