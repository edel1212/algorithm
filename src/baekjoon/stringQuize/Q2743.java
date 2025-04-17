package baekjoon.stringQuize;

import java.io.*;

public class Q2743 {
    /**
     * 알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            String str = br.readLine();
            bw.write(String.valueOf(str.length()));
            bw.flush();
            } catch (IOException io){
                io.printStackTrace();
            }
    }
}
