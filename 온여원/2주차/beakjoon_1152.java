import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
    public static void main (String[] args) throws IOException { // throws IOException은 readLine()을 사용할 떄 필요함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();  // 한 줄 입력 받기
        StringTokenizer st = new StringTokenizer(line);  // 공백을 기준으로 분리
        int a = st.countTokens();  // 단어의 개수를 얻는 방법
        System.out.println(a);

    }
}