package baekjoon.stringQuize;

import java.io.*;

public class Q11654 {
    /**
     * 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // char 로 변경해 준다음 해줘야한다.!!!
            //String str = br.readLine();
            //bw.write(Integer.valueOf(str)); << 내가 했던 코드 [ 입력값 그대로 나옴 ]
            //bw.write(Integer.valueOf(br.readLine().charAt(0))); << 내가 했던 코드 2 [ 입력값 그대로 나옴 ]

            int c = br.readLine().charAt(0);
            //bw.write(c);    << 내가 했던 코드 3 [ 입력값 그대로 나옴 ]
            bw.write(String.valueOf(c));
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }

    }
}
