package squareAndTriangle;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q3009 {
    /**
     * 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // x 위치 배열
            int[] xPoints = new int[3];
            // y 위치 배열
            int[] yPoints = new int[3];

            // 각각 배열에 값 을 넣어준다.
            for(int i = 0 ; i < 3 ; i++){
                StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");
                xPoints[i] = Integer.valueOf(strToken.nextToken());
                yPoints[i] = Integer.valueOf(strToken.nextToken());
            }//for

            /**
             * 각각 x,y별로 같은 값이 2개씩 존재하므로 2개가 아닌 값을 출력
             * */

            if(xPoints[0] == xPoints[1]){
                bw.write(String.valueOf(xPoints[2]));
            } else if(xPoints[0] == xPoints[2]){
                bw.write(String.valueOf(xPoints[1]));
            } else {
                bw.write(String.valueOf(xPoints[0]));
            }

            bw.write(" ");

            if(yPoints[0] == yPoints[1]){
                bw.write(String.valueOf(yPoints[2]));
            } else if(yPoints[0] == yPoints[2]){
                bw.write(String.valueOf(yPoints[1]));
            } else {
                bw.write(String.valueOf(yPoints[0]));
            }

            bw.flush();

        } catch(IOException io){
            io.printStackTrace();
        }

    }
}
