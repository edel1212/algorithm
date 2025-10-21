package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 오큰수_R3 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 길이
        int N = Integer.parseInt(br.readLine());
        // 정답
        int[] answer = new int[N];
        // 수열의 값을 저장할 배열
        int[] A = new int[N];

        // A Array initializer
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ;i++){
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        } // for

        // stack
        Deque<Integer> stack = new ArrayDeque<>();

        // 초기 index 값 지정 - A의 크기 N (1 ≤ N ≤ 1,000,000)
        stack.push(0);

        for(int i = 1 ; i < N ; i++){ // 1번 부터 시작은 stack에 초기 값 index0을 할당 함

            while(!stack.isEmpty() && A[stack.peek()] < A[i]){
                answer[stack.pop()] = A[i];
            } // while

            stack.push(i);
        } // for

        // 처리 되지 못한 값 (오큰수가 아닌 값)
        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        } // while

        // 결과 반환
        for(int result : answer){
            bw.write(result + " ");
        } // for

        bw.flush();
        bw.close();

    }
}
