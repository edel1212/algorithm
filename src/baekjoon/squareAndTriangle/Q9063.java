package baekjoon.squareAndTriangle;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q9063 {
    /**
     * 임씨의 이름이 새겨진 옥구슬의 위치 N 개가 주어질 때에, 임씨에게 돌아갈 대지의 넓이를 계산하는 프로그램을 작성하시오.
     * 단, 옥구슬의 위치는 2 차원 정수 좌표로 주어지고 옥구슬은 같은 위치에 여러 개가 발견될 수도 있으며,
     * x 축의 양의방향을 동쪽, y 축의 양의방향을 북쪽이라고 가정한다.
     *
     * 첫째 줄에는 점의 개수 N (1 ≤ N ≤ 100,000) 이 주어진다. 이어지는 N 줄에는 각 점의 좌표가 두 개의 정수로 한 줄에 하나씩 주어진다.
     * 각각의 좌표는 -10,000 이상 10,000 이하의 정수이다.
     * */
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            Integer cnt = Integer.valueOf(String.valueOf(br.readLine()));

            int[] xArr = new int[cnt];
            int[] yArr = new int[cnt];
            for(int x = 0 ; x < cnt; x++){
                StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");
                xArr[x] = Integer.valueOf(strToken.nextToken());
                yArr[x] = Integer.valueOf(strToken.nextToken());
            }//for

            int width = Arrays.stream(xArr).max().getAsInt() - Arrays.stream(xArr).min().getAsInt();
            int height = Arrays.stream(yArr).max().getAsInt() - Arrays.stream(yArr).min().getAsInt();

            bw.write(String.valueOf(width *  height));

        } catch(IOException io){
            io.printStackTrace();
        }

    }

}
