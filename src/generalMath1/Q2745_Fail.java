package generalMath1;

import java.io.*;
import java.util.StringTokenizer;

public class Q2745_Fail {
    /**
     * B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
     *
     * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
     *
     * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 진법  번환 대상을 받아옴
            StringTokenizer strToken = new StringTokenizer(br.readLine());

            // 받아온 진법
            String N = strToken.nextToken();

            // 변환 대상값
            int B = Integer.valueOf(strToken.nextToken());

            // 변환 값
            long result = 0;

            /**
             * 틀린 이유
             * Math.pow(,)의 반환 유형은 소수인데 이것을
             * long으로 변환시 값을 잃을수 있음
             * 값이 낮을 경우는 상관없으나 값이 커질수록 오류가 발생하는 코드임
             * **/

            // 받아온 진법 계산
            for(int i =0 ; i < N.length() ; i++){
                // 단어 값
                char c = N.charAt(i);
                if('A'<= c && c <= 'Z'){
                    int parseCharToInt = c - 55;
                    if(i == 0){
                        result +=  parseCharToInt;
                    } else{
                        result +=  parseCharToInt * Math.pow(B,i);
                    }
                } else{
                    if(i ==0){
                        result +=  Integer.valueOf(Character.toString(c));
                    } else{
                        result +=  Integer.valueOf(Character.toString(c)) * Math.pow(B,i);
                    }
                }
            }//for
            bw.write(String.valueOf(result));
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
