package week1.programmers.lv2;

import java.util.*;

public class P42746 {
    public String solution(int[] numbers) {

        String[] strNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        // 합친 문자열 기준 내림차순 되도록 정렬
        Arrays.sort(strNumbers, (a,b) -> (b+a).compareTo(a+b) );

        if(strNumbers[0].equals("0")) return "0"; // 어이없슨;;

        StringBuilder sb = new StringBuilder();
        for(String s : strNumbers){
            sb.append(s);
        }


        return sb.toString();
    }

    // 로컬 테스트를 위한 main 함수 (제출 시 복사 X)
    public static void main(String[] args) {
        P42746 s = new P42746();

        // 테스트 케이스 1
        int[] input1 = {6, 10, 2};
        System.out.println("Test 1: " + s.solution(input1));
        // Expected: "6210"

        // 테스트 케이스 2
        int[] input2 = {3, 30, 34, 5, 9};
        System.out.println("Test 2: " + s.solution(input2));
        // Expected: "9534330"

        // 테스트 케이스 3
        int[] input3 = {0, 0, 0, 0};
        System.out.println("Test 3: " + s.solution(input3));
        // Expected: "0" (not "0000")
    }


}
