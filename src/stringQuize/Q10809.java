package stringQuize;

import java.io.*;

public class Q10809 {
    /**
     * 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 입력 받은 단어 S
            String S = br.readLine();

            // ASCII 코드 기준 소문자 a ~ z 까지 Loop
            for(int ascii = 97 ; ascii <= 122 ; ascii++){
                char pasreChar = (char) ascii;
                bw.write(String.valueOf(S.indexOf(pasreChar)));
                bw.write(" ");
            }//for
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
