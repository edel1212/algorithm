package generalMath1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2745_Succ {
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

            // 받아온 진법 계산
            for(int i =0 ; i < N.length() ; i++){
                // 각각의 문자를 받음
                char c = N.charAt(i);
                // 문자로 받아온 값을
                int num;
                if('A' <= c && c <= 'Z'){
                    // 👉 아스키 코드변환
                    // 'A'의 값은 60 + 10 을 해줌으로 써 예제에서 원하는 숫자로 변환 가능
                    num = c - 'A' + 10;
                } else{
                    // 👉 아스키 코드는 '0'을 빼주면 숫자로 변환된다.
                    num = c - '0';
                }
                // Math.pow()가 아닌 제곱 계산
                result = result * B + num;
            }//for

            bw.write(String.valueOf(result));
            bw.flush();

        } catch(IOException io){
            io.printStackTrace();
        }
    }


}
