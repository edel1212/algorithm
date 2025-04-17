package baekjoon.generalMath1;

import java.io.*;

public class Q1193_Fail {
    /**
     * 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그
     * 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
     *
     * X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int position = Integer.valueOf(br.readLine());

            int x = 1;
            int y = 1;

            int tmp = 2;

            // 지그제그 기준
            boolean invertFlag = false;

            if(1 < position){
                for(int i = 0 ; i < position ; i++){

                    // 1  -- 1

                    // 2번째 -- 2
                    tmp += 1;

                    // 4번째 -- 4

                    // 7번쨰는 -- 7

                    if((i+1) == tmp){
                        y++;
                        invertFlag = true;
                        continue;
                    }

                    if(invertFlag){
                        x++;
                        y--;
                    }else {
                        x--;
                        y++;
                    }// if - else

                    //1
                    x++;
                    y++;

                    // 2   👉
                    y++;

                    //3
                    x++;
                    y--;

                    //4 👉
                    x++;

                    //5
                    x--;
                    y++;

                    // 6
                    x--;
                    y++;

                    //7  👉
                    y++;

                    //8
                    x++;
                    y--;

                    //9
                    x++;
                    y--;

                    //10
                    x++;
                    y--;

                    //11 👉
                    x++;


                }//for
            }//if



        } catch(IOException io){
            io.printStackTrace();
        }

    }
}
