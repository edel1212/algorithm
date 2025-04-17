package baekjoon.stringQuize;

import java.io.*;

public class Q11718 {
    /**
     * 입력 받은 대로 출력하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            do{
                bw.write(br.readLine());
                bw.newLine();
            } while(br.ready());
            bw.flush();
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
