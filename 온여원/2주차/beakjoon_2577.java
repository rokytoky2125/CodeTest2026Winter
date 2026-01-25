import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main (String[] args) throws IOException { // throws IOException은 readLine()을 사용할 떄 필요함
        int A, B, C;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        int result = A * B * C;
        String s = String.valueOf(result);  // 정수를 문자열로 바꿀 때는 String.valueOf 사용 vs 문자열을 정수로 바꿀 때는 Integer.parseInt 사용, result값의 숫자를 하나씩 문자열로 인식
        int[] arr = new int[10];  // arr[0]=0, arr[1]=0, ... , arr[9]=0 현재 이 상태임

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // charAt은 문자열에 있는 문자를 순서대로 꺼내는 역할
            int n = c - '0';
            arr[n]++;  // c에 등장한 숫자의 횟수를 카운트함
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}