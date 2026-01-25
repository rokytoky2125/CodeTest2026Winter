package week1.boj.p6198;

import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        solve(N);
        System.out.println(sb.toString());
    }

    static void solve(int N) throws IOException{
        Deque<Integer> stack = new ArrayDeque<>();
        long result = 0;

        for(int i = 0 ; i <N;i++){
            int curHeight = Integer.parseInt(br.readLine());


            while (!stack.isEmpty() && stack.peekLast() <= curHeight){
                stack.pollLast(); // 현재 건물보다 높이 작은 건물들 : 현재 건물(+이후 건물) 볼 가망 없으므로 삭제
            }

            result+=stack.size(); // stack 에 남아있는 얘들 : 현재 건물 볼 수 있는 얘들
            stack.offerLast(curHeight);
        }

        sb.append(result);

    }

}
