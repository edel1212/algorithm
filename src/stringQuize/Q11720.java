package stringQuize;

import java.io.*;

public class Q11720 {

    /**
     * N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 숫자 개수
            int N = Integer.valueOf(br.readLine());
            // 입력 받은 값ㄴ
            String param = br.readLine();

            int result = 0;
            for(int i = 0 ; i < N ; i++){
                //☠️ result += Integer.valueOf(param.charAt(i)); << - 해당 방식은 아스키 코드가 나옴
                result += Character.getNumericValue(param.charAt(i));
            }//for

            // ☠️  bw.write(result);                            << - 해당 방식은 아스키 코드가 나옴
            bw.write(String.valueOf(result));
            bw.flush();
        } catch (IOException io){
            io.printStackTrace();
        }

    }

}
