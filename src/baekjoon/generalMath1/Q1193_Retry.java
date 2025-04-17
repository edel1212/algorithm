package baekjoon.generalMath1;

import java.io.*;

public class Q1193_Retry {
    /**
     * 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그
     * 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
     *
     * X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int selectNum = Integer.valueOf(br.readLine());

            int baseCross = 1;
            int maxBlock  = 0;

            while(true){
                if( selectNum <= baseCross + maxBlock ){ //이건 체크용값임 진짜 max값이 아님
                    int child  = 0; // 분자
                    int parent = 0; // 분모
                    // 홀,짝 체크 증,감 위치가 다름
                    if(baseCross %2 != 0){
                        child = baseCross - (selectNum - maxBlock - 1 );
                        parent  = selectNum - maxBlock;  // 내가고른값 - 이전대 각선 Max값
                    }else{
                        child = selectNum - maxBlock;    // 내가고른값 - 이전대 각선 Max값
                        parent = baseCross - (selectNum - maxBlock - 1);
                    }// if - else
                    bw.write(child+"/"+parent);
                    bw.flush();
                    break;
                } else{
                    // 다음 대각선 누적 블럭값을 구함
                    maxBlock +=  baseCross;
                    // 다음 대각선으로 변경
                    baseCross++;
                }// if - else
            }// while
        } catch(IOException io){
            io.printStackTrace();
        }

    }
}
