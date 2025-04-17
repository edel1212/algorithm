package baekjoon.generalMath1;

import java.io.*;

public class Q2292 {
    /**
     * 위의 그림과 같이 육각형으로 이루어진 벌집이 있다.
     * 그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 숫자 N이 주어졌을 때,
     * 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오.
     * 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 입력 받은 값
            int selectNum = Integer.valueOf(br.readLine());

            // 기준 시작 값
            int tmp = 1;

            int result = 1;

            if(1 < selectNum){
                // 이상으로하면 안된다 한번이 더 추가됨
                // result를 안에서 올리기 떄문임!
                while(tmp < selectNum){
                    // 기존 숫자 + 횟수 * 6
                    tmp = tmp + result * 6;
                    result++;
                }//while
            }//if

            bw.write(String.valueOf(result));
            bw.flush();
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
