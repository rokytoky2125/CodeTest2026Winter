package week1.boj.p11279;


import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args)throws IOException{
        int N = Integer.parseInt(br.readLine());
        solve(N);
        System.out.println(sb.toString());
    }

    static void solve(int N) throws IOException{
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙 기준

        for(int i = 0 ; i <N;i++){
            int cur = Integer.parseInt(br.readLine());
            if (cur != 0 ) pq.offer(cur);
            else if (pq.isEmpty()) sb.append(0).append('\n');
            else sb.append(pq.poll()).append('\n');
        }




    }

}
