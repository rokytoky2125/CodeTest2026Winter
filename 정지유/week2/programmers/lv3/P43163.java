package week2.programmers.lv3;

import java.util.*;

class P43163 {

    boolean[] visited ;

    static class Node {
        String word;
        int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) { // String[] words = map/graph


        // 엣지 케이스 : target이 words 안에 없는 경우
        boolean containsTarget = false;
        for (String w : words) {
            if (w.equals(target)) {
                containsTarget = true;
                break;
            }
        }
        if (!containsTarget) return 0;

        visited = new boolean[words.length];

        return bfs(begin, target, words);
    }

    // BFS
    private int bfs(String begin, String target, String[] words) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(begin, 0));

        while (!q.isEmpty()) {

            Node curr = q.pollFirst();

            // 기저 조건
            if (curr.word.equals(target)) return curr.count;

            // 탐색
            for (int i = 0; i < words.length; i++) {

                if (!visited[i]) {

                    int diffCount = 0;
                    for (int k = 0; k < curr.word.length(); k++) {
                        if (curr.word.charAt(k) != words[i].charAt(k)) {
                            diffCount++;
                        }
                    }


                    if (diffCount == 1) { // 문제 조건 : 딱 한 글자만 다를 때
                        q.offerLast(new Node(words[i], curr.count + 1));
                        visited[i] = true;
                    }
                }
            }
        }

        return 0; // 변환 불가
    }

    public static void main(String[] args) {
        P43163 s = new P43163();

        // 테스트 케이스 1
        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(s.solution(begin1, target1, words1)); // Expected: 4

        // 테스트 케이스 2 (target이 없는 경우)
        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(s.solution(begin2, target2, words2)); // Expected: 0
    }
}
