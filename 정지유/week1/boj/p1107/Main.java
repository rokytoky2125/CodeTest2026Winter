package week1.boj.p1107;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder() ;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N  = Integer.parseInt(br.readLine());
        int M  = Integer.parseInt(br.readLine());
        solve(N,M);
        System.out.println(sb.toString());
    }

    static void solve(int N, int M) throws IOException{
        boolean[] brokenButtons = new boolean[10]; // 0~9

        // 고장난 버튼 등록
        if(M>0){
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                int btn = Integer.parseInt(st.nextToken());
                brokenButtons[btn]=true;
            }
        }

        // min 횟수 초기화 : +- 버튼만 활용하는 케이스
        int minPress = Math.abs(N-100); // 현재 채널은 100번

        // 0~999 999 채널 완전 탐색
        for(int i= 0; i<= 999999;i++){
            String strNum  = String.valueOf(i); // 몇자린지/각자리수 구하는 용도
            boolean isUsable = true;

            // 이번 채널 번호의 broken button 포함여부 검사
            for(int j = 0 ; j<strNum.length();j++){
                int valIdx = strNum.charAt(j)-'0'; // j번째 자릿수
                if(brokenButtons[valIdx]){
                    isUsable=false;
                    break;
                }
            }

            // broken button 이 포함되지 않은 채널이면 최솟값 비교
            if(isUsable){
                int press = strNum.length() + Math.abs(N-i); // (해당 채널의 숫자 버튼 누르는 횟수) + (그 숫자서 +- 누르는횟수)
                minPress = Math.min(minPress,press);
            }

        }

        sb.append(minPress);

    }
}
