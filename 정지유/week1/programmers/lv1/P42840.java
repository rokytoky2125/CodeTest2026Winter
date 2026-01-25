package week1.programmers.lv1;

import java.util.*;

class P42840 {
    public int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        // 채점
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) scores[0]++;
            if (answers[i] == pattern2[i % pattern2.length]) scores[1]++;
            if (answers[i] == pattern3[i % pattern3.length]) scores[2]++;
        }

        // 최고점 확인
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        int cnt = 0;
        for (int score : scores) {
            if (score == maxScore) cnt++;
        }

        int[] result = new int[cnt];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                result[idx++] = i + 1; // 1번 수포자부터
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P42840 s = new P42840();

        // 테스트 케이스 1
        int[] input1 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 1: " + Arrays.toString(s.solution(input1)));
        // Expected: [1]

        // 테스트 케이스 2
        int[] input2 = {1, 3, 2, 4, 2};
        System.out.println("Test Case 2: " + Arrays.toString(s.solution(input2)));
        // Expected: [1, 2, 3]
    }
}