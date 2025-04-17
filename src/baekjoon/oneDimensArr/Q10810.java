package baekjoon.oneDimensArr;

import java.io.*;
import java.util.StringTokenizer;

public class Q10810 {
    public static void main(String[] args) throws Exception{
        /**
         * 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다.
         * 또, 1번부터 N번까지 번호가 적혀있는 공을 매우 많이 가지고 있다. 가장 처음 바구니에는 공이 들어있지 않으며,
         * 바구니에는 공을 1개만 넣을 수 있다.
         * 도현이는 앞으로 M번 공을 넣으려고 한다. 도현이는 한 번 공을 넣을 때, 공을 넣을 바구니 범위를 정하고,
         * 정한 바구니에 모두 같은 번호가 적혀있는 공을 넣는다. 만약, 바구니에 공이 이미 있는 경우에는 들어있는 공을 빼고,
         * 새로 공을 넣는다. 공을 넣을 바구니는 연속되어 있어야 한다.
         *
         * 공을 어떻게 넣을지가 주어졌을 때, M번 공을 넣은 이후에 각 바구니에 어떤 공이 들어 있는지 구하는 프로그램을 작성하시오.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer init = new StringTokenizer(br.readLine(), " ");

        // 바구니의 개수
        int N = Integer.valueOf(init.nextToken());
        // 바구니의 개수만큼 0으로 채워진 배열 생성
        int[] result = new int[N];
        // 공을 넣으려는 횟수
        int M = Integer.valueOf(init.nextToken());

        StringTokenizer throwBallInit = null;
        for(int i = 0 ; i < M ; i++){
            throwBallInit = new StringTokenizer(br.readLine(), " ");
            int throwStartNum = Integer.valueOf(throwBallInit.nextToken());
            int throwEndNum   = Integer.valueOf(throwBallInit.nextToken());
            int throwBallNum  = Integer.valueOf(throwBallInit.nextToken());
            for(int j = throwStartNum; j <= throwEndNum; j++){
                // Index를 예제와 맞춤
                result[j-1] = throwBallNum;
            }//for
        };// for
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i : result){
            bw.write(String.valueOf(i));
            bw.write(" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
