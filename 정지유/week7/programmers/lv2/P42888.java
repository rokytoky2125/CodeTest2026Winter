package week7.programmers.lv2;

import java.util.*;

class P42888 {
    public String[] solution(String[] record) {

        Map<String, String> userMap = new HashMap<>();
        int messageCount = 0;

        // 1차 순회: UID별 최종 닉네임 갱신 및 메시지 개수 파악
        for (String r : record) {
            String[] parts = r.split(" ");
            String action = parts[0];
            String uid = parts[1];

            if (action.equals("Enter") || action.equals("Change")) {
                String nickname = parts[2];
                userMap.put(uid, nickname);
            }

            if (action.equals("Enter") || action.equals("Leave")) {
                messageCount++;
            }
        }

        // 2차 순회: 갱신된 최종 닉네임을 바탕으로 결과 문자열 배열 생성
        String[] answer = new String[messageCount];
        int idx = 0;

        for (String r : record) {
            String[] parts = r.split(" ");
            String action = parts[0];
            String uid = parts[1];

            if (action.equals("Enter")) {
                answer[idx++] = userMap.get(uid) + "님이 들어왔습니다.";
            } else if (action.equals("Leave")) {
                answer[idx++] = userMap.get(uid) + "님이 나갔습니다.";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P42888 s = new P42888();

        System.out.println(Arrays.toString(s.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }
}