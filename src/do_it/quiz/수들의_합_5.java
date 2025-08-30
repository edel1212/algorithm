package do_it.quiz;

import java.io.*;

public class 수들의_합_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int start = 1;
        int end = 1;
        int sum = 1;

        while(end != N){ // 해당 로직으로 인해 N(자기 자신)은 제외 되기에 count를 1로 초기화 함
            if( sum == N ){
                count++;
                end++;
                sum += end;
            } else if(sum < N){
                end++;
                sum += end;
            } else {
                // ✅ 값을 빼줄 때는 start point를 빼기전에 작업 해줘야함
                start++;
                sum -= start;
            } // if - else
        } // while

        bw.write(String.valueOf(count));
        bw.flush();
    }
}
