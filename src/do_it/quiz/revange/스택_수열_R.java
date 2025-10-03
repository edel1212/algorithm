package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 스택_수열_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean isPossible = true;

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0 ; i < arr.length; i++) arr[i] = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        int currentNum = 1;

        for(int i = 0 ; i < arr.length; i++){

            //  배열내 값
            int currentArrNum = arr[i];

            if( currentNum <= currentArrNum ){  // 추가할 값이 있을 경우

                // 필요한 값이 충족 될 때까지 push
                while(currentNum <= currentArrNum){
                    stack.push(currentNum);
                    currentNum++;
                    sb.append("+\n");
                } // while

                // 지정 수 까지 도달 하였을 때 pop 1회 진행
                stack.pop();
                sb.append("-\n");

            } else{                             // 추가할 값이 없을 경우

                int pop = stack.pop();

                if(currentArrNum < pop){
                    bw.write("NO");
                    isPossible = false;
                    break;
                } else {
                    sb.append("-\n");
                } // if - else

            } // if - else

        } // for

        if(isPossible) bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
