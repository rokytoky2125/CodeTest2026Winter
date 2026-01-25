package week1.boj.p10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st ;
    static  Map<Integer,Integer> card_cnt = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


        while(st.hasMoreTokens()){
            int cur_key = Integer.parseInt(st.nextToken());
            int cur_cnt = card_cnt.getOrDefault(cur_key,0)+1;
            card_cnt.put(cur_key,cur_cnt);
        }

        int m = Integer.parseInt(br.readLine());
        solve();
        System.out.print(sb.toString());

    }

    static void solve() throws IOException{
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int cur_key = Integer.parseInt(st.nextToken());
            sb.append(card_cnt.getOrDefault(cur_key,0)).append(' ');
        }


    }
}
