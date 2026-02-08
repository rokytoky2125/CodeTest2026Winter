import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
    public static void main (String[] args) throws IOException { // throws IOException은 readLine()을 사용할 떄 필요함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine().trim());  // trim() : 문자열 양쪽의 공백 제거
        StringBuilder output = new StringBuilder();  // println을 여러 번 쓰는 대신 여기에 모았다가 마지마겡 한 번에 출력

        for (int tc = 0; tc < A; tc++) {
            String s = br.readLine().trim();  // 한 줄의 문자열 읽기
            int streak = 0;  // 현재 연속된 O의 갯수
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);  // 문자열 s에서 i번 째 문자를 꺼냄
                if(c == 'O') {
                    streak++;
                    sum += streak;
                }
                else {
                    streak = 0;
                }
            }
            output.append(sum);  // append() : 문자열 뒤에 추가
            if(tc != A - 1) {
                output.append('\n');
            }
        }
        System.out.println(output);
    }
}