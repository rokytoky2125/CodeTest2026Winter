package week3.programmers.lv2;

import java.util.*;

class P43238 {
    public long solution(int n, int[] times) {

        // 탐색 대상을 정렬
        Arrays.sort(times);

        return binarySearch(n, times);
    }

    private long binarySearch(int n, int[] times) {
        // 초기 설정
        long minBoundary = 1;
        long maxBoundary = (long) times[times.length - 1] * n; // 최대 시간: 가장 느린 심사관이 혼자서 모든 사람을 심사할 때 걸리는 시간
        long result = maxBoundary;

        while (minBoundary <= maxBoundary) {

            long mid = (minBoundary + maxBoundary) / 2;

            // 중간 기준으로 조건 성립 여부 판단 및 범위 조정
            if (check(mid, n, times)) {
                result = mid;
                maxBoundary = mid - 1; // 더 적게 가능한지 확인
            } else {
                minBoundary = mid + 1; // mid 시간 안에 n명 심사 불가능 -> 시간을 더 늘려야 함
            }
        }
        return result;
    }

    // givenTime 동안 모든 사람(n명)을 심사할 수 있는가
    private boolean check(long givenTime, int n, int[] times) {
        long totalProcessed = 0;

        for (int time : times) {
            totalProcessed += (givenTime / time);
            // 중간에 이미 n명을 넘었다면
            if (totalProcessed >= n) return true;
        }

        return totalProcessed >= n;
    }


    public static void main(String[] args) {
        P43238 s = new P43238();

        // 테스트 케이스 1
        System.out.println(s.solution(6, new int[]{7, 10})); // Expected: 28
    }
}