package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 오큰수_R4 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 수열
        int N = Integer.parseInt(br.readLine());
        // 수를 저장할 배열
        int[] A = new int[N];
        // 정답을 저장할 배열
        int[] R = new int[N];

        // 배열 내 값 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        } // for

        // 배열의 인덱스를 담을 스택 선언
        Deque<Integer> stack = new ArrayDeque<>();

        // 0번째 인덱스 init
        stack.push(0);

        // A[0]번을 기준으로 찾기에 1번 인덱스 부터 탐색
        for(int i = 1; i < N ; i++){

            // 스택에 저장된 값이 A 보다 작을 경우
            while(!stack.isEmpty() && A[stack.peek()] < A[i]){
                R[stack.pop()] = A[i];
            } // while

            // 인덱스 값 주입
            stack.push(i);
        } // for

        // 처리 되지 못한 값 (오큰수가 아닌 값)
        while(!stack.isEmpty()){
            R[stack.pop()] = -1;
        } // while

        // 결과 반환
        for(int result : R){
            bw.write(result + " ");
        } // for

        bw.flush();
        bw.close();
    }


}
