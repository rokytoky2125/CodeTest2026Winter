package week2.boj.p15686;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, ans = Integer.MAX_VALUE;

    // 이동 목적이 아닌 점 들간의 연산(거리) 구하기 (가이드라인 TYPE A-2)-> map X. List<Node> O.
    static ArrayList<Node> houses = new ArrayList<>();
    static ArrayList<Node> chickens = new ArrayList<>();

    // TYPE A-2 -> 네이밍을 visited 가 아닌 selected 로 (헷갈 방지)
    static boolean[] selected;

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) houses.add(new Node(r, c));
                else if (val == 2) chickens.add(new Node(r, c));
            }
        }

        selected = new boolean[chickens.size()];

        solve();

        System.out.println(sb.toString());

    }

    static void solve() throws IOException {

        dfs(0, 0);
        sb.append(ans);


    }


    // DFS TypB - 조합
    static void dfs(int start, int count) {
        // 기저 조건
        if (count == M) {
            int cityChickenDist = 0;

            // 집을 기준으로 : 집은 고정, 치킨집이 선택인거라
            for (Node h : houses) {
                int minHouseDist = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (selected[i]) {
                        Node ch = chickens.get(i);
                        // 거리 계산: |r1 - r2| + |c1 - c2|
                        int dist = Math.abs(h.r - ch.r) + Math.abs(h.c - ch.c);
                        minHouseDist = Math.min(minHouseDist, dist);
                    }
                }
                cityChickenDist += minHouseDist;

                // 가지치기 : 중간 합계가 이미 최솟값을 넘었다면
                if (cityChickenDist >= ans) return;
            }

            ans = Math.min(ans, cityChickenDist);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[i] = true;   // 치킨집 선택 (체크인)
            dfs(i + 1, count + 1);
            selected[i] = false;  // 체크아웃
        }
    }
}
