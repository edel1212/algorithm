package baekjoon.factorsMuiltiplesDecimals;

import java.io.*;
import java.util.*;

public class Q2501 {
    /**
     * 어떤 자연수 p와 q가 있을 때, 만일 p를 q로 나누었을 때 나머지가 0이면 q는 p의 약수이다.
     *
     * 6을 예로 들면
     *
     * 6 ÷ 1 = 6 … 0
     * 6 ÷ 2 = 3 … 0
     * 6 ÷ 3 = 2 … 0
     * 6 ÷ 4 = 1 … 2
     * 6 ÷ 5 = 1 … 1
     * 6 ÷ 6 = 1 … 0
     * 그래서 6의 약수는 1, 2, 3, 6, 총 네 개이다.
     *
     * 두 개의 자연수 N과 K가 주어졌을 때, N의 약수들 중 K번째로 작은 수를 출력하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer strToken = new StringTokenizer(br.readLine());

            int N = Integer.valueOf(strToken.nextToken());
            int K = Integer.valueOf(strToken.nextToken());

            List<Integer> arr = new ArrayList<>();

            int tmp = 0;
            while( tmp < N ){
                tmp++;
                if(N % tmp == 0 ) arr.add(tmp);
            }//while

            if(arr.size() < K){
                bw.write("0");
            } else{
                bw.write(String.valueOf(arr.get(K-1)));
            }

            bw.flush();

        }catch(IOException io){
            io.printStackTrace();
        }

    }
}
