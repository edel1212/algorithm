package do_it.quiz;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 스택으로_수열_만들기{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 응답값 출력 여부 - 중간에 반환을 못할 경우 "NO"만 출력 해야함
        boolean result = true;
        // 응답 메세지
        StringBuilder sb = new StringBuilder();

        // 수의 범위
        int N = Integer.parseInt(br.readLine());
        // 배열 초기화
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(br.readLine());

        // 스택 선언
        Deque<Integer> stack = new ArrayDeque<>();

        // stack에 추가 될 값
        int current = 1 ;

        // 배열의 범위까지 Loop
        for(int i = 0 ; i < arr.length; i++){

            // 배열 내 값
            int currentArr = arr[i];

            // 현재 값 보다 배열의 값이 클 경우
            if( current <= currentArr ){

                // 현재 값을 배열의 값 까지 Loop
                while( current <= currentArr){
                    // 스택에 추가
                    stack.push(current);
                    // num ++
                    current++;
                    sb.append("+\n");
                } // while

                // 지정 범위 수 까지 왔을 경우 pop 후 '-' 출력
                stack.pop();
                sb.append("-\n");
            } else {    // 현재 값이 더 클 경우
                // 현자 값을 맞추기 위해 pop
                int pop = stack.pop();

                if( currentArr < pop   ){
                    System.out.println("NO");
                    result = false;
                    break;
                }  else {
                    sb.append("-\n");
                } // if - else

            } // if - else

        }// for

        if(result) bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
