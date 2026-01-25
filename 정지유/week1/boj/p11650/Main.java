package week1.boj.p11650;


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        solve(N);
        System.out.println( sb.toString() );
    }

    static class Point{
        int x,y;
        Point(int x , int y){
            this.x = x;
            this.y = y;
        }
    }

    static void solve(int N) throws IOException{
        List<Point> pointList = new ArrayList<>();

        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pointList.add(new Point(x,y));
        }

        // 두가지 기준으로 오름차순 정렬
        pointList.sort( (a,b) -> {
            if (a.x!=b.x) return Integer.compare(a.x,b.x);
            return Integer.compare(a.y,b.y);
        } );

        for(Point p : pointList){
            sb.append(p.x).append(' ').append(p.y).append('\n');
        }





    }

}
