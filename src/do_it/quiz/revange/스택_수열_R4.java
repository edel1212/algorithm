package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 스택_수열_R4 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 수의 개수
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();

        boolean isPossible = true;

        int number = 1;

        for(int i = 0 ; i < N ; i++){
            // 스택에 넣을 입력 받은 값
            int v = Integer.parseInt(br.readLine());

            // 값 추가
            while(number <= v){
                stack.push(number);
                sb.append("+").append("\n");
                number++;
            } // while


            if (stack.peek() == v) {
                stack.pop();
                sb.append("-\n");
            } else {
                isPossible = false;
                break;
            } // if - else

        } // for

        if(isPossible){
            bw.write(sb.toString());
        } else {
            bw.write("NO");
        } // if - else
        bw.flush();
        bw.close();
    }
}
