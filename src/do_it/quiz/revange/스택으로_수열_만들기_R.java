package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 스택으로_수열_만들기_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        int num = 1;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        for(int i = 0 ; i < arr.length; i++){

            if(num <= arr[i]){
                while(num <= arr[i]){
                    stack.push(num);
                    num++;
                    sb.append("+\n");
                } // while

                // ✅ 마지막 값 pop 및 - 처리
                stack.pop();
                sb.append("-\n");
            } else {
                int pop = stack.pop();
                if( arr[i] < pop ){
                    bw.write("NO");
                    flag = false;
                    break;
                } // if
                sb.append("-\n");
            } // if - else

        } // for

        if(flag) bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
