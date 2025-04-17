package baekjoon.intensiveStep1;

import java.io.*;

public class Q2444 {
    /**
     * <h1>예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.</h1>
     * <p>입력 :5</p>
     *     *
     *    ***
     *   *****
     *  *******
     * *********
     *  *******
     *   *****
     *    ***
     *     *
     * */
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 입력 받은 값
            int N = Integer.parseInt(br.readLine());

            //상단 별
            for(int i = 0; i < N-1; i++){
                for(int j = N - 1; j > i; j--){
                    bw.write(" ");
                }
                for(int z = 0 ; z <= (i*2) ; z++){
                    bw.write("*");
                }
                bw.newLine();
            }//for
            //하단 별
            for(int i = 0; i < N; i++){
                for(int z = 0 ; z < i ; z++){
                    bw.write(" ");
                }
                for(int j = N *2 -1; j > i*2; j--){
                    bw.write("*");
                }
                bw.newLine();
            }//for
            bw.flush();
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
