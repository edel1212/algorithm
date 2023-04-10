package stringQuize;

import java.io.*;

public class Q9086 {
    /**
     *  문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int T = Integer.valueOf(br.readLine());

            for(int i = 0; i < T; i++){
                String result = br.readLine();
                bw.write(result.charAt(0));
                bw.write(result.charAt(result.length()-1));
                bw.newLine();
            }//for
            bw.flush();
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
