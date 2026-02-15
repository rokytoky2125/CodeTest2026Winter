import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { // throws IOException은 readLine()을 사용할 때 필요함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 첫 번째 줄
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[6];  // 두 번째 줄
        for (int i = 0; i < 6; i++) {  // 배열에 정수 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());  // 마지막 줄
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int t = 0;

        for (int i = 0; i < 6; i++) {
            int a = 0;
            a = (arr[i] / T) + 1;
            if (arr[i] % T == 0) {
                a = arr[i] / T;
            }
            t += a;
        }

        int p = N / P;
        int s = N % P;

        System.out.println(t);
        System.out.println(p + " " + s);

    }
}