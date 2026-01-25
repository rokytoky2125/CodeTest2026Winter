package week2.boj.p7569;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken()); // col
        N=Integer.parseInt(st.nextToken()); // row
        H=Integer.parseInt(st.nextToken());

        solve(M,N,H);

        System.out.println(sb.toString());
    }

    // 3차원 환경
    static int M,N,H;
    static int[][][] map;
    static boolean[][][] visited;

    // 방향 벡터 : 왼 오 윗행 아랫행 아래층 위층
    static int[] dc = {-1,1,0,0,0,0};
    static int[] dr = {0,0,-1,1,0,0};
    static int[] dh = {0,0,0,0,-1,1};

    static class Node{
        int r,c,h;
        int dist;

        Node(int r,int c,int h, int dist){
            this.r = r;
            this.c = c;
            this.h = h;
            this.dist = dist;
        }
    }

    static Deque<Node> q = new ArrayDeque<>();

    static void solve(int c,int r,int h) throws IOException{

        // 환경 초기화
        map = new int[h][r][c];
        visited = new boolean[h][r][c];

        for(int i=0 ; i<h ; i++){
            for(int j=0 ; j<r ; j++){
                st = new StringTokenizer(br.readLine());
                for(int z=0; z<c ; z++){
                    map[i][j][z]=Integer.parseInt(st.nextToken());

                    //  bfs 호출전 q 초기화 : N개의 시작점
                    if(map[i][j][z]==1){
                        q.offerLast(new Node(j,z,i,0));
                        visited[i][j][z]=true;
                    }
                }
            }
        }

        // bfs 수행
        int totalDays = bfs(c,r,h);


        // 실패 검사
        for(int i=0 ; i<h ; i++){
            for(int j=0 ; j<r ; j++){
                for(int z=0; z<c ; z++){
                    if(map[i][j][z]==0){
                        sb.append(-1);
                        return;
                    }
                }
            }
        }

        sb.append(totalDays);



    }


    // N:M 타입
    static int bfs(int c,int r,int h){
        int maxDays=0;

        while(!q.isEmpty()){
            Node node = q.pollFirst();
            maxDays = Math.max(maxDays,node.dist );

            // 6방향 탐색
            for(int i=0 ; i<6 ; i++){
                int nc = node.c+dc[i];
                int nr = node.r+dr[i];
                int nh = node.h+dh[i];

                if( 0<= nc && nc < M && 0<= nr && nr <N && 0<= nh && nh < H){ // 기본 조건
                            if(!visited[nh][nr][nc] && map[nh][nr][nc] ==0 ){ // 문제 조건 : 안익은 토마토
                                q.offerLast(new Node(nr,nc,nh,node.dist+1));
                                map[nh][nr][nc] =1;
                                visited[nh][nr][nc]=true;
                            }
                }

            }

        }

        return maxDays;

    }

}
