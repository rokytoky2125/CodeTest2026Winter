import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main{
    public static void main (String[] args) throws IOException {
        int[] a = new int [9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// BufferedReader : 사용자 입력 받기 (문자열로 인식함)
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0; i<9; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int max = -1;

        for (int i = 0; i < 9; i++) {
            if (a[i] > max) {
                max = Math.max(a[i],max);

                index = i;
            }
        }

        sb.append(max+"\n");
        sb.append(index + 1);
        System.out.println(sb);
    }
}
