package week1.boj.p1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb= new StringBuilder();
    static StringTokenizer st ;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine()); // 기본 띄어쓰기 구분자
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        solution(n,m);
        System.out.println(sb.toString());
    }


    static void solution(int n, int m) throws IOException {

        // 번호를 인덱스로, 이름을 값으로
        String[] numToName = new String[n+1]; // 몇 개 저장할지 정해짐 -> 걍 ary 사용

        // 이름을 key 로, 번호를 value 로
        Map<String, Integer> nameToNum = new HashMap<>();

        // 도감 입력 받기
        for(int i=1; i<=n;i++){
            String name = br.readLine();
            numToName[i] = name; // 번호기반으로 이름 저장
            nameToNum.put(name,i); // 이름기반으로 번호 저장
        }
        
        // 문제 입력 및 처리
        for(int i =0;i<m;i++){
            String query=br.readLine();

            // 첫 글자로 문자/숫자 여부 판단
            if(Character.isDigit(query.charAt(0))){
                int num = Integer.parseInt(query);
                sb.append(numToName[num]).append('\n');
            }
            else{
                sb.append(nameToNum.get(query)).append('\n');
            }

        }



    }
}
