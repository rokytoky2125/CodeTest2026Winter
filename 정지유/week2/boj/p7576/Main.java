package week2.boj.p7576;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N,M;
    static int[][] map;
    static boolean[][] visited;

    // 방향 벡터 : 상 하 좌 우
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};

    // N:M 타입 BFS 를 위한 전역 큐
    static Deque<Node> q = new ArrayDeque<>();

    static class Node{
        int r,c;
        int dist ; // 익는데 걸리는 날

        Node(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // col
        N = Integer.parseInt(st.nextToken()); // row

        solve(M,N);

        System.out.println(sb.toString());
        


    }


    static void solve(int M,int N) throws IOException{
        // map , visited 초기화
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i <N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                //  bfs 호출전 q 초기화 : N개의 시작점(익은 토마토 기준)
                if(map[i][j] == 1){
                    q.offerLast(new Node(i,j,0)); // 0일차
                    visited[i][j]=true;
                }

            }
        }

        // bfs 수행
        int totalDays = bfs(N,M); // row , col

        // 실패 여부 확인 : 안익은 토마토가 있나
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0) {
                    sb.append(-1);
                    return;
                }
            }
        }

        sb.append(totalDays);



    }



    // N:M 타입
    static int bfs(int r, int c){
        // 전역 큐 사용

        int maxDist = 0; // 마지막에 익은 토마토의 dist(날짜)가 전체 소요 시간

        while(!q.isEmpty()){
            Node curr = q.pollFirst();
            maxDist = Math.max(maxDist, curr.dist); // dist 증가시 자동 반영

            // 4방향 탐색
            for(int i = 0 ; i<4;i++){
                int nr = curr.r+dr[i];
                int nc = curr.c+dc[i];

                if( 0<= nr && nr < r && 0 <= nc && nc <c){ // 디폴트 조건 체크
                    if(!visited[nr][nc] && map[nr][nc]==0) { // 문제 조건 체크 (안익은 토마토)
                        q.offerLast(new Node(nr,nc, curr.dist+1));
                        visited[nr][nc]=true;
                        map[nr][nc] = 1; // 익음

                    }

                }

            }


        }

        return maxDist;
    }
}
