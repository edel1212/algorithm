package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 오큰수_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 결과 저장
        int[] resultArr = new int[N];
        // 인덱스 순서 stack
        Deque<Integer> indexStack = new ArrayDeque<>();

        // 배열 선언
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i ++) arr[i] = Integer.parseInt(tokenizer.nextToken());

        // 초기 첫번째 값 주입
        indexStack.push(0);

        for(int i = 1 ; i < N ; i++){

            // 내 다음 수의 값이 더 큰 경우
            while(!indexStack.isEmpty() && arr[indexStack.peek()] < arr[i]){
                resultArr[indexStack.pop()] = arr[i];
            } // while

            indexStack.push(i);
        } // for


        while(!indexStack.isEmpty()){
            resultArr[indexStack.pop()] = -1;
        } // while

        for(int i : resultArr){
            bw.write(i + " ");
        } // for

        bw.flush();
        bw.close();
    }
}
