package do_it.quiz;

import java.io.*;

public class 수들의_합_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;

        while(endIndex != N){ // 해당 로직으로 인해 N(자기 자신)은 제외 되기에 count를 1로 초기화 함
            if( sum == N ){
                count++;
                endIndex++;
                sum += endIndex;
            } else if(sum < N){
                endIndex++;
                sum += endIndex;
            } else {
                // ✅ 값을 빼줄 때는 start Point를 빼기전에 작업 해줘야함
                startIndex++;
                sum -= startIndex;
            } // if - else
        } // while

        bw.write(String.valueOf(count));
        bw.flush();
    }
}
