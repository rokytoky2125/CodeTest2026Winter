package week2.boj.p15686;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, ans = Integer.MAX_VALUE;
    static ArrayList<int[]> houses = new ArrayList<>();
    static ArrayList<int[]> chickens = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        solve();

        System.out.println(ans);

    }

    static void solve() throws IOException {

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) houses.add(new int[]{i, j});
                else if (type == 2) chickens.add(new int[]{i, j});
            }
        }

        visited = new boolean[chickens.size()];

        dfs(0, 0);

    }

    static void dfs(int start, int count) {

        if (count == M) {
            int totalCityDist = 0;

            for (int[] h : houses) {
                int minHouseDist = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (visited[i]) {
                        int[] c = chickens.get(i);
                        int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                        minHouseDist = Math.min(minHouseDist, dist);
                    }
                }
                totalCityDist += minHouseDist;
                if (totalCityDist >= ans) return; // 가지치기
            }

            ans = Math.min(ans, totalCityDist);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            visited[i] = true;   // 체크인
            dfs(i + 1, count + 1);
            visited[i] = false;  // 체크아웃
        }
    }
}