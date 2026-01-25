package week1.boj.p1158;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args ) throws IOException{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        solve(N,K);

        System.out.println(sb.toString());

    }

    static void solve(int N, int K) throws IOException{
         Deque<Integer> queue = new ArrayDeque<>();

         //큐 초기화
         for(int i = 1 ; i <= N ; i++){
             queue.offerLast(i);
         }

         sb.append('<');

         // 원형큐 빙글빙글
        while(!queue.isEmpty()){
            // k-1 번까지는 빼고 다시 넣음
            for(int i = 0 ; i <K-1;i++){
                queue.offerLast(queue.pollFirst());
            }

            // K 번째는 처리
            sb.append(queue.pollFirst());

            // 콤마 처리
            if (!queue.isEmpty())  sb.append(", ");

        }

         sb.append('>');
    }
}
