package week1.boj.p18870;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        solve(N);
        System.out.println(sb.toString());
    }

    static void solve(int N) throws IOException {
        // 원본 배열
        int[] originArr = new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            originArr[i]=Integer.parseInt(st.nextToken());
        }

        // 압축 배열
        // 치환 단계에서 원본 배열 활용 필요하여 별도의 배열 객체 생성
        int[] sortedArr = Arrays.copyOfRange(originArr,0,N);

        // 1. 배열 정렬
        Arrays.sort(sortedArr);

        // 압축값 매핑 위한 Map : < 값, 해당값앞의요소갯수 >
        HashMap<Integer,Integer> countMap = new HashMap<>();
        int count = 0;

        // 2. 중복 제거 + 매핑
        for(int value : sortedArr){
            if(!countMap.containsKey(value)){ // 중복 제거 효과
                countMap.put(value,count);
                count++;
            }
        }

        // 3. 치환
        for(int key: originArr){ // 원본 배열의 순서대로
            sb.append(countMap.get(key)).append(' ');
        }

    }
}
