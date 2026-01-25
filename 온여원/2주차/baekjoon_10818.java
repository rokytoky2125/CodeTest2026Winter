

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
    public static void main (String[] args) throws IOException { // throws IOException은 readLine()을 사용할 떄 필요함
        int a;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;  // 가장 작은 정수
        int min = Integer.MAX_VALUE; // 가장 큰 정수

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < a; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp > max) {
                max = tmp;
            }
            if (min > tmp) {
                min = tmp;
            }
        }
        System.out.println(min+" "+max);

    }
}