package factorsMuiltiplesDecimals;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1978 {
    /**
     * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 숫자 개수
            int N = Integer.valueOf(br.readLine());

            // 소수 개수
            int cnt = 0;

            StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < N ; i++){
                // 소수를 담을 배열
                List<Integer> tmp = new ArrayList<>();
                // 소수를 찾아낸다
                int num = Integer.valueOf(strToken.nextToken());
                for(int j = 1 ; j <= num ; j++){
                    if( num%j == 0 ){
                        tmp.add(j);
                    }//if
                }//for

                // 1과 자기자신일 경우 증감
                if(tmp.size() == 2) cnt++;
            }//for
            bw.write(String.valueOf(cnt));
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
