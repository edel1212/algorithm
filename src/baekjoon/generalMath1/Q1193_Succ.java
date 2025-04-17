package baekjoon.generalMath1;

import java.io.*;

public class Q1193_Succ {
    /**
     * 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그
     * 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
     *
     * X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 입력 받은 값
            int X = Integer.valueOf(br.readLine());

            // 해당 범위의 대각선의 위치 == 블록 개수랑 같음
            int crossCnt    = 1;
            // 대각선들의 누석 합
            int prevCntSun  = 0;

            // 반복
            while(true){
                /** 입력 받은 값이 <= 대각선 누적합 + 현재 대각선 위치 **/
                if(X <= prevCntSun +  crossCnt){    // 총블럭개수의 Max값범위내에 있을경우 - ✅ 해당 값이 대각선 라인의 맥스값임
                    int x;
                    int y;
                    /**
                     * 👉 대각선의 위치값을 홀짝 체크
                     *  - 홀수 일경우 : 분자 -- 분모 ++
                     *  - 짝수일 경우 : 분자 ++ 분모 --
                     *
                     *  💬 ++ 일경우 : 현재 대각라인[블록개수랑 같음] - ( 내가고른 위치 - 총 블럭개수 - 1)
                     *     -- 일경우  : 내가고른 위치 - Max블럭 값
                     * */
                    if(crossCnt %2 != 0){  // 홀수
                        x = crossCnt - (X - prevCntSun - 1);
                        y = X - prevCntSun;
                    } else {               // 짝수
                        x = X - prevCntSun;
                        y = crossCnt - (X - prevCntSun - 1);
                    }// if - else
                    bw.write(x +"/"+y);
                    bw.flush();
                    break;
                } else {                            // 해당 대각선 범위내에 없을 경우 범위를 증가
                    prevCntSun += crossCnt;
                    crossCnt++;
                } // if - else
            }// while
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
