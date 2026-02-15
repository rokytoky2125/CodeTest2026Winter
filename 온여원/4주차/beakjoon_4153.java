import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException { // throws IOException은 readLine()을 사용할 떄 필요함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {  // 입력의 끝까지 계속 반복
            if (line.trim().isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int max = Math.max(a, Math.max(b, c));
            int min = Math.min(a, Math.min(b, c));
            int mid = a + b + c - max - min;

            if (line.equals("0 0 0")) {
                break;
            }

            if (max*max == mid*mid + min*min) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
        }

    }
}