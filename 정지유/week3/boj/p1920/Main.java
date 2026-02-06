package week3.boj.p1920;


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int M;
    static int[] A;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        
        solve();
        
        System.out.print(sb.toString());
    }


    static void solve() throws IOException{
        st = new StringTokenizer(br.readLine());
        
        // 이분 탐색 전제 조건
        Arrays.sort(A);
        
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(A, target)).append('\n');
        }
    }

    // mid 가 인덱스 -> 걍 int (long 아닌)
    static int binarySearch(int[] arr, int target) {
        int min_boundary = 0;
        int max_boundary = arr.length - 1;

        while (min_boundary <= max_boundary) {
            int mid = (min_boundary + max_boundary) / 2;

            if (arr[mid] == target) return 1;
            else if (arr[mid] < target) min_boundary = mid + 1;
            else max_boundary = mid - 1;
        }

        return 0; // 탐색 실패
    }
}