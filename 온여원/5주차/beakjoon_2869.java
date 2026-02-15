import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { // throws IOException은 readLine()을 사용할 때 필요함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int x;

        x = (V - A) / (A - B);
        if ((V - A) % (A - B) != 0) {
            x++;
        }
        x++;  // 마지막 날

        System.out.println(x);
    }
}