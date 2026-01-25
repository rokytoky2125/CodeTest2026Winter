package week1.boj.p1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {

        // 입력
        st = new StringTokenizer(br.readLine()); // delim 명시 없음 기본 스페이스 구분자
        int n  = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        solve(n,m);

        System.out.println(sb.toString());

    }

    static void solve(int n, int m) throws IOException{

        Set<String> unheard_set = new HashSet<>(); // 비교 대상 집합만 set 로 저장
        for(int i = 0; i<n ; i++){
            unheard_set.add(br.readLine());
        }

        ArrayList<String> reuslt = new ArrayList<>(); // 결과 리스트

        for(int i =0 ; i < m;i++){ // 별도 저장 없이 입력 받는 즉시 비교
            String unseen_name = br.readLine();
            if(unheard_set.contains(unseen_name)){
                reuslt.add(unseen_name);
            }
        }

        Collections.sort(reuslt);
        sb.append(reuslt.size()).append("\n");;

        for(String name :reuslt){
            sb.append(name).append("\n");
        }

    }
}
