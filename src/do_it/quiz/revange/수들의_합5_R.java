package do_it.quiz.revange;

import java.io.*;

public class 수들의_합5_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        int count = 0;
        // 첫 시작 값은 1부터 시작하기에 포인터의 시작 값은 전부 1
        int left = 1;
        int right = 1;
        // 합 또한 1부터 시작하기에 1로 시작
        int sum = 1;

        while(right <= N){
            if(sum < N){
                // 값이 부족하니 추가
                right++;
                sum += right;
            } else if(sum > N){
                // ✅ 포인트 값을 먼저 빼준 후 포인터를 이동해 줘야함 초기 sum init을 생각해보자
                sum -= left;
                left++;
            } else {
                count++;
                sum -= left;
                left++;
            }
        } // while

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
