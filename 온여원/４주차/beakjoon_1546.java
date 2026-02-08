import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;


public class Main {
    public static void main(String[] args) throws IOException { // throws IOException은 readLine()을 사용할 때 필요함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int max = 0;
        double sum = 0;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {  // 배열에 정수 저장
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        for (int i = 0; i < N; i++) {  // 최대값 구하기
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int i = 0; i < N; i++) {
            double a = (double) (arr[i] * 100) / max;
            sum += a;
        }

        double average = sum / N;  // 강제 형변환
        System.out.println(average);
    }
}