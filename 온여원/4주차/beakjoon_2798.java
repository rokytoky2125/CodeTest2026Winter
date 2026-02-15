import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { // throws IOException은 readLine()을 사용할 때 필요함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());  // 카드 정수
        int[] arr = new int[N];


        for (int i = 0; i < N; i++) {  // 배열에 정수 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;  // 갱신하는 값

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum <= M) {
                        if (sum > max) {
                            max = sum;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}