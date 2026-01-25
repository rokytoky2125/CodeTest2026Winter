import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main{
    public static void main (String[] args) throws IOException { // throws IOException은 readLine()을 사용할 떄 필요함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>(); // 자료구조, 중복 제거

        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(br.readLine()); // 한 줄 입력
            set.add(x % 42); // 자료구조
        }

        System.out.println(set.size());
    }
}