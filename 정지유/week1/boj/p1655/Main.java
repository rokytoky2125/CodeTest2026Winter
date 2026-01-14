package week1.boj.p1655;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        solve(N);
        System.out.println(sb.toString());
    }

    static void solve(int N) throws IOException{

        PriorityQueue<Integer> smallerGroupHeap = new PriorityQueue<>(Collections.reverseOrder());  // 작은값 그룹은 최대힙으로 관리
        PriorityQueue<Integer> biggerGroupHeap = new PriorityQueue<>(); // 큰 값 그룹은 최소힙으로 관리

        for(int i = 0 ; i <N;i++){
            int curNum = Integer.parseInt(br.readLine());

            // 1. 삽입
            // 작은값 우선시 -> smallerGroupHeap 기준 구현
            if(smallerGroupHeap.size() == biggerGroupHeap.size()) smallerGroupHeap.offer(curNum);
            else  biggerGroupHeap.offer(curNum);

            // 2. 보정
            if( !biggerGroupHeap.isEmpty() && smallerGroupHeap.peek() > biggerGroupHeap.peek() ){ // 작은값 그룹 max 값이, 큰 값 그룹 min 값 보다 큰 상황

                int smallerNum = biggerGroupHeap.poll();
                int biggerNum = smallerGroupHeap.poll();

                //swap
                smallerGroupHeap.offer(smallerNum);
                biggerGroupHeap.offer(biggerNum);
            }

            // 3 . 중간값 반환
            sb.append(smallerGroupHeap.peek()).append('\n'); // 주의 : 출력했다고 제거하는게 아니라 peek
        }




    }
}
