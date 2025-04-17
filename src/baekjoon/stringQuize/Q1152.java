package baekjoon.stringQuize;

import java.io.*;
import java.util.StringTokenizer;

public class Q1152 {
    /**
     * 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까?
     * 이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            /**
             * ☠️ 내가한 오답 .. 결과값은 같으나 계속 틀림
             *  String param = br.readLine().trim();
             *  bw.write(String.valueOf(param.split(" ").length));
             * 👉 이유 :  공백 하나만 포함된 문자열일 경우(" ") 답은 0이 되어야 하는데
             *           내가 작성한 코드는 " "도 1개로 인식
             *
             *    이유2 : split() 은 빈 문자열도 토큰으로 인식하는 반면,
             *           StringTokenizer는 빈 문자열을 토큰으로 인식하지 않기 때문에 토큰 개수에 차이가 있는 것을 확인할 수 있다.
             * */

            StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");
            bw.write(String.valueOf(strToken.countTokens()));
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
