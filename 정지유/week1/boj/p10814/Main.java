package week1.boj.p10814;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st ;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        solve(N);
        System.out.println(sb.toString());
    }

    static class Member{
        String name;
        int age;

        Member(String name , int age){
            this.name = name;
            this.age = age;
        }

    }

    static void solve(int N) throws IOException{

        Member[] memberAry = new Member[N];

        for(int i = 0 ; i <N ; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            memberAry[i] = new Member(name,age);
        }

        // 나이 오름차순 정렬
        Arrays.sort( memberAry, (a,b) -> Integer.compare(a.age, b.age));

        for(Member m : memberAry){
            sb.append(m.age).append(' ').append(m.name).append('\n');
        }




    }
}
