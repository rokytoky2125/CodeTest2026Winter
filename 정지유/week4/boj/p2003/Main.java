package week4.boj.p2003;


import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int N,M;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(sb.toString());
    }

    static void solve() {
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum >= M) {
                if (sum == M) count++;
                sum -= arr[start++];
            }

            else if (end == N) {
                break;
            }

            else {
                sum += arr[end++];
            }
        }

        sb.append(count);
    }
}