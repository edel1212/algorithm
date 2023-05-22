package factorsMuiltiplesDecimals;

import java.io.*;

public class Q11653 {
    /**
     * 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            // 받아온 정수
            int num = Integer.valueOf(br.readLine());

            // 소인수 분해는 2부터 시작
            int o  = 2;
            while(num != 1 && true){

                // 2로 나눠서 떨어지지 않을경우 ++
                if(num%o != 0){
                    o++;
                    continue;
                }

                bw.write(String.valueOf(o));
                bw.newLine();

                // num값 변경
                num /= o;

                // 대상이 0 이되면 종료
                if(num == 0) break;
            }//while
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
