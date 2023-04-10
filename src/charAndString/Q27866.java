package charAndString;

import java.io.*;

public class Q27866 {
    /**
     * 단어 S와 정수 i가 주어졌을 때,
     * S의 i번째 글자를 출력하는 프로그램을 작성하시오.
     * */

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 단어 S
            String S = br.readLine();
            // 정수 i
            int i = Integer.valueOf(br.readLine());

            bw.write(S.substring(i-1,i));
            bw.flush();

        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
