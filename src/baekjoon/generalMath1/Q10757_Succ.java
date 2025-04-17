package baekjoon.generalMath1;

import java.io.*;
import java.util.StringTokenizer;

public class Q10757_Succ {
    /**
     * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
     *
     * 첫째 줄에 A와 B가 주어진다. (0 < A,B < 10 ^10000) 만승
     * */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer strToken = new StringTokenizer(br.readLine());

            String A = strToken.nextToken();
            String B = strToken.nextToken();

            // 1 . 일단 각각의 문자열의 길이를 구한 후 가징 높인 자릿수를 구함
            int max = Math.max(A.length(), B.length());

            // 2 . 가장 높은 숫자를 기준으로 배열을 int 배열 생성 비자리는 자동으로 0으로 매꿔짐
            // - 단 여기서 포인트는 덧셈의 기준이 될 tmpA에는  덧셈 시 자릿수가 올라 갈수있으니 +1 해준다
            int[] tmpA = new int[max + 1];
            int[] tmpB = new int[max];

            // 만들어진 배열 값 저장 - 역순으로 저장하는 이유는 그게 덧셈하기 더 쉬움
            // 자릿수 걱정을 안해도된다.
            // A
            for(int i = A.length() -1 , idx = 0 ; i >=0 ; i-- , idx++){
                tmpA[idx] = A.charAt(i) - '0';
            }//for

            // B
            for(int i = B.length() -1 , idx = 0 ; i >=0 ; i-- , idx++){
                tmpB[idx] = B.charAt(i) - '0';
            }//for

            // 덧셈 - 최대 자릿숫자 만큼
            for(int i = 0 ; i < max ; i ++){
                int hap = tmpA[i] + tmpB[i];        // 덧셈을 하지만 이 숫자는 1의 자리를 초화할수 있음
                tmpA[i] = hap % 10;                 // 10을 나눈 나머지를 주입해 주면 된다.
                tmpA[i + 1] = tmpA[i+1] + hap/10;  // 올라간 자릿수는 10을 나눈 몫의 값임
            }//for

            // 가장 높은 자릿수 체크 0일경우 출력하면 안되기 때문
            if(tmpA[max] != 0){
                bw.write(String.valueOf(tmpA[max]));
            }//if

            // 첫자리를 제외한 나머지 역순 출력
            for(int i = max -1 ; i >= 0 ; i--){
                bw.write(String.valueOf(tmpA[i]));
            }//for

            bw.flush();

        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
