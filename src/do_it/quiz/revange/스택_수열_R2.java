package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 스택_수열_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int current = 1;
        boolean isPossible = true;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0 ; i < N ; i++){
            int target = Integer.parseInt(br.readLine());
            while(current <= target){
                stack.push(current);
                current++;
                sb.append("+\n");
            } // while

            if(stack.peek() == target){
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
