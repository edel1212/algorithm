package factorsMuiltiplesDecimals;

import java.io.*;
import java.util.StringTokenizer;

public class Q5086 {
    /**
     * 4 × 3 = 12이다.
     *
     * 이 식을 통해 다음과 같은 사실을 알 수 있다.
     *
     * 3은 12의 약수이고, 12는 3의 배수이다.
     *
     * 4도 12의 약수이고, 12는 4의 배수이다.
     *
     * 두 수가 주어졌을 때, 다음 3가지 중 어떤 관계인지 구하는 프로그램을 작성하시오.
     *
     * 첫 번째 숫자가 두 번째 숫자의 약수이다.
     * 첫 번째 숫자가 두 번째 숫자의 배수이다.
     * 첫 번째 숫자가 두 번째 숫자의 약수와 배수 모두 아니다.
     * */
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            while (true){

                StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");

                int x = Integer.valueOf(strToken.nextToken());
                int y = Integer.valueOf(strToken.nextToken());

                // 0 0 일 경우 종료
                if(x == 0 && y == 0) break;

//                if(x < y){
//                    if(y%x == 0){
//                        bw.write("factor");
//                    }  else {
//                        bw.write("neither");
//                    }
//                } else{
//                    if(x%y == 0){
//                        bw.write("multiple");
//                    }  else {
//                        bw.write("neither");
//                    }
//                }

                // 개선
                if(x % y == 0){
                    bw.write("factor");
                } else if(y % x == 0){
                    bw.write("multiple");
                } else{
                    bw.write("neither");
                }//if - else

                bw.newLine();
            }//while
            bw.flush();
        }catch(IOException io){
            io.printStackTrace();
        }

    }

}
