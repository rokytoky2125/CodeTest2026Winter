import java.sql.SQLOutput;
import java.util.Scanner;

public class Main{
    public static void main (String[] args) {
        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        int i = a + b - c;
        System.out.println(i);

        String s = String.valueOf(a);
        String p = String.valueOf(b);
        String q = s + p;
        int j = Integer.parseInt(q);
        int k = j - c;
        System.out.println(k);
    }
}
