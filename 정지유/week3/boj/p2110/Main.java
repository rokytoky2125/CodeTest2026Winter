package week3.boj.p2110;


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, C;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        solve();

        System.out.println(sb.toString());
    }

    static void solve() {
        // 이분 탐색 전 정렬 필수
        Arrays.sort(houses);
        int maxDistance= houses[N - 1] - houses[0];
        binarySearch(maxDistance);
    }

    static void binarySearch(int maxDistance) {
        int min_boundary = 1; // 0 아님 주의
        int max_boundary = maxDistance;
        int result = 0;

        while (min_boundary <= max_boundary) {

            int mid = (min_boundary + max_boundary) / 2;

            if (check(mid)) {
                result = mid;
                min_boundary = mid + 1;
            } else {
                max_boundary = mid - 1;
            }
        }
        sb.append(result);
    }

 
    // 거리 dist 이상으로 공유기 C개를 설치할 수 있는가
    static boolean check(int dist) {
        // 첫 번째 집에는 무조건 설치하는 것이 유리
        int count = 1;
        int lastInstalledPosition = houses[0];

        for (int i = 1; i < N; i++) {
            // 현재 집의 위치가 마지막 설치 위치로부터 dist 이상 떨어져 있다면 설치
            if (houses[i] - lastInstalledPosition >= dist) {
                count++;
                lastInstalledPosition = houses[i];
            }
        }
        return count >= C;
    }
}