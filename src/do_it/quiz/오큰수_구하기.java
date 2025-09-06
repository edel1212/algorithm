package do_it.quiz;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 오큰수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 수 할당
        int N = Integer.parseInt(br.readLine());
        // 수열 배열
        int[] arr = new int[N];
        // 결과 값 저장
        int[] resultArr = new int[N];
        // 수열 init
        String[] arrStr = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(arrStr[i]);;
        }  // for

        // 스택 인덱스 저장
        Deque<Integer> stack = new ArrayDeque<>();
        // 초기 첫 값은 항상 비어 있으므로 0 주입
        stack.push(0);
        // 첫 값은 0으로 치환하여 stack에 저장하였기에 1부터 시작
        for(int i = 1; i < N ; i++){

            // 스택에 값이 있으면서
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                // 결과 값 배열[ 스택 값 ] = 현재 Index 배열 값
                resultArr[ stack.pop() ] = arr[ i ];
            } // while

            // 스택에 값 주입 - Index 번호
            stack.push(i);

        } // for


        while(!stack.isEmpty()){
            resultArr[stack.pop()] = -1;
        } // while


        // 결과 반환
        for(int result : resultArr){
            bw.write(result + " ");
        } // for

        bw.flush();
        bw.close();
    }
}
