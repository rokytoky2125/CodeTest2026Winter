package week1.programmers.lv2;

import java.util.*;

class P42842 {
    public int[] solution(int brown, int yellow) {
        int totalSize = brown + yellow;

        // height 기준 완전탐색
        for (int height = 3; height * height <= totalSize; height++) { // 가로 >= 세로 라서 세로는 totalSize의 제곱근까지만 확인하면 ㅇㅋ

            // 전체 크기가 현재 세로 길이로 나누어떨어지면 유효한 사각형 후보
            if (totalSize % height == 0) {
                int width = totalSize / height;

                //  (width - 2) * (height - 2) : 테두리 1줄을 뺀 내부 크기
                if ((width - 2) * (height - 2) == yellow) return new int[]{width, height};
            }
        }

        return new int[]{};
    }

    // 로컬 테스트를 위한 main 함수 (제출 시 복사 X)
    public static void main(String[] args) {
        P42842 s = new P42842();

        // 테스트 케이스 1
        System.out.println(Arrays.toString(s.solution(10, 2)));

        // 테스트 케이스 2
        System.out.println(Arrays.toString(s.solution(8, 1)));

        // 테스트 케이스 3
        System.out.println(Arrays.toString(s.solution(24, 24)));
    }
}