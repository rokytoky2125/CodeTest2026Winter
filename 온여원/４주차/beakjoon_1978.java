import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static boolean isPrime (int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {  // 2부터 √n까지만 검사
            if (n % i == 0) {
                return false;
            }
        }
        return true;  // 소수만 true
    }

    public static void main(String[] args) throws IOException { // throws IOException은 readLine()을 사용할 떄 필요함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime(num)) {
                count++;
            }
        }
        System.out.println(count);
    }
}