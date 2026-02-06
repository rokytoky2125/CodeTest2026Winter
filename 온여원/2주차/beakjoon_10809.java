import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main{
    public static void main (String[] args) throws IOException { // throws IOException은 readLine()을 사용할 떄 필요함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] arr = new int[26];
        Arrays.fill(arr, -1); // 전부 -1로 초기화

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i); // word에 있는 i번 째 문자를 하나 꺼내서 c에 저장
            int idx = c - 'a'; // a=0, b=1, ...
            if(arr[idx] == -1) {
                arr[idx] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}