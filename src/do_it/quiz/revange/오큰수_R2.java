package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 오큰수_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 개수
        int N = Integer.parseInt(br.readLine());
        // 정답
        int[] answer = new int[N];
        // 값을 저장할 배열
        int[] A = new int[N];

        // 배열 init
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) A[i] = Integer.parseInt(tokenizer.nextToken());

        // stack 생성
        Deque<Integer> stack = new ArrayDeque<>();

        // 초기 0 값 주입 (이유 ?)
        stack.push(0);

        // 0번 index는 초기에 stack에 주입하였기에 1번부터 시작
        for(int i = 1 ; i < N ;i++){

            // stack에 저장된 값보다 신규 값이 더 클 경우
            while(!stack.isEmpty() && A[stack.peek()] < A[i]){
                //  오큰 수 이기에 결과에 저장
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
