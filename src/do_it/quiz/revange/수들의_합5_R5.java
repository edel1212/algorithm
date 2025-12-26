package do_it.quiz.revange;

import java.io.*;

public class 수들의_합5_R5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int sum  = 1;
        int count = 1;

        while(end != N){
            if( sum <= N ){
                if(sum == N) count++;
                start++;
                sum += start;
            } else {
                sum -= end;
                end++;
            }// if - else
        } // while

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
