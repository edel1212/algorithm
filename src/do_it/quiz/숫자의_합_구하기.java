package do_it.quiz;

import java.io.*;

public class 숫자의_합_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String num = br.readLine();

        int answer = 0;
        for(char c : num.toCharArray()){
            // ✅ 아스키 값 기준 - '0'을 빼주면 원하는 정수 값이 나온다
            answer += c - '0' ;
        } // for

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
