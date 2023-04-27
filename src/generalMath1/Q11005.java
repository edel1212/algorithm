package generalMath1;

import java.io.*;
import java.util.StringTokenizer;

public class Q11005 {
    /**
     * 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
     *
     * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
     *
     * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
     * */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer strToken = new StringTokenizer(br.readLine());

            // 10진법
            long N = Integer.valueOf(strToken.nextToken());

            // 변환 할 진법
            int B  = Integer.valueOf(strToken.nextToken());

            StringBuilder result = new StringBuilder();

            if(N < B){
                result.append(parseAlphabet(N));
            } else{
                while(true){
                    result.append(parseAlphabet(N%B));
                    N /= B;
                    if(N < B){
                        result.append(parseAlphabet(N));
                        break;
                    }//if
                }// while
            }// if - else
            bw.write(result.reverse().toString());
            bw.flush();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private static char parseAlphabet(long number){
        char result;
        if(number < 10){
            result = (char) (number + '0');
        } else{
            result = (char) (number + 'A' - 10);
        }
        return result;
    }

}
