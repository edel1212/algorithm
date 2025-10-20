package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 스택_수열_R3 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean isPossible = true;
        int current = 1;

        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());

            while (current <= v) {
                stack.push(current++);
                sb.append("+\n");
            }

            if (stack.peek() == v) {
                stack.pop();
                sb.append("-\n");
            } else {
                isPossible = false;
                break;
            }
        }

        if(isPossible){
            bw.write(sb.toString());
        } else {
            bw.write("NO");
        } // if - else
        bw.flush();
        bw.close();

    }
}
