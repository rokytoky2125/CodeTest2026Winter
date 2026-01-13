package week1.boj.p2493;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        solve(N,s);
        System.out.println(sb.toString());

    }

    static class Tower{
        int idx;
        int height;

        public Tower(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }

    static void solve(int N, String s){
        st = new StringTokenizer(s); // 하나씩 순서대로 꺼내볼꺼라 split 안쓰고 걍 Tokenizer 씀

        // stack : 신호 받을 수 있는 후보들 저장
        ArrayDeque<Tower> stack = new ArrayDeque<>();

        for(int i = 1; i<=N ; i++){ // 번호는 1부터 시작
            int curHeight = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){ // 현재 타워의 신호 받을 수 있는 후보 있으면
                if(stack.peekLast().height >= curHeight){ // 왼편 후보와 높이 비교
                    // pollLast 가 아닌 peekLast() 적용 : 해당 타워 뿐 아니라 뒷 타워의 신호를 추가 수신 받을 수 있어서
                    sb.append(stack.peekLast().idx).append(' ');
                    break;
                }
                stack.pollLast(); // 후보 검사했는데 탈락한 얘들: 가망이 없음 -> stack 에서 아예 제거

            }

            // 스택 다 뒤졌는데도 가능한 얘 없으면
            if(stack.isEmpty()) sb.append("0 ");
            stack.offerLast(new Tower(i, curHeight)); // 현재 타워를 가장 최신으로 추가
            
        }



    }
}
