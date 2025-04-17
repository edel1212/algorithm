package baekjoon.generalMath1;

import java.io.*;
import java.util.StringTokenizer;

public class Q2869_Fail {
    /**
     * 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
     *
     * 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
     *
     * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
     *
     * 첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
     *
     * 첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer init = new StringTokenizer(br.readLine());

            // 낮에 올라간 높이
            int A = Integer.valueOf(init.nextToken());
            // 밤에 자면서 미끄러진 높이
            int B = Integer.valueOf(init.nextToken());
            // 목표하는 높이
            int V = Integer.valueOf(init.nextToken());

            /**
             * 순서는 낮->밤이 아닌 밤 -> 낮으로 시작
             * 0은 -가 될수없음
             * */
            // 올라간 횟수
            int resultCnt = 0;
            // 누적값
            int tmp = 0;
            while(true){
                if(V <= tmp) break;
                resultCnt ++;
                if(tmp <= 0){
                    tmp += A;
                } else{
                    tmp = tmp - B + A;
                }
            }//while
            bw.write(String.valueOf(resultCnt));
            bw.flush();
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
