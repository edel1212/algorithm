package baekjoon.generalMath1;

import java.io.*;
import java.util.StringTokenizer;

public class Q2745_Retry {
    /**
     * B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
     *
     * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
     *
     * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            // 진법  번환 대상을 받아옴
            StringTokenizer strToken = new StringTokenizer(br.readLine());

            // 받아온 진법
            String N = strToken.nextToken();

            // 변환 대상값
            int B = Integer.valueOf(strToken.nextToken());

            // 변환 값
            long result = 0;

            for(int c = 0 ; c < N.length(); c++){
                char tmpChar = N.charAt(c);
                int tmp = 0;
                if('A' <= tmpChar && tmpChar <= 'Z'){
                    tmp = tmpChar - 'A' + 10;
                } else {
                    tmp = tmpChar - '0';
                }
                result += (long) Math.pow(B, N.length()-1-c) * tmp;

                /**
                 * 당연히 아래 코드가 안되는 이유는
                 * 위에서 구하는 tmpChar는 index가 0부터 시작이니 .. 당연하다 ..
                 * ex) 1010 -- >  tmpchar = 1, 0, 1, 0
                 *
                 * 이니 아래의 제곱방법 또한 역순으로 해줘야지 ..
                 * */
                //result += (long) Math.pow(B, c) * tmp;  // 👉 당연 .. tmpchar가 인덱스 순이니 ..

            }//for

            bw.write(String.valueOf(result));
            bw.flush();

        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
