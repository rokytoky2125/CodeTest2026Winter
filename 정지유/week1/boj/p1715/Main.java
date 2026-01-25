package week1.boj.p1715;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        solve(N);
        System.out.println(sb.toString());

    }

    static void solve(int N) throws IOException {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // 우선순위 큐(최소힙) 초기화
        for(int i = 0 ; i <N ; i++){
            pq.offer(Long.parseLong(br.readLine()));
        }

        long total = 0 ;

        // 허프만st
        while(pq.size()>1){

            // 최솟값 2개 poll
            long card1 = pq.poll();
            long card2 = pq.poll();

            long sum = card1+card2;
            total +=sum;

            // 최솟값 2개로 구한 하나의 값 offer
            pq.offer(sum);

        }

        sb.append(total);
    }


}
