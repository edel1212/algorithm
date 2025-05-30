package baekjoon.bruteForce;

import java.io.*;

public class Q19532 {
    /**
     * 다음 연립방정식에서 x 와 y 의 값을 계산 하시오
     * ax + by = c
     * dx + ey =f
     *
     * 빈 칸에 수들을 입력하는 식이다. 각 칸에는 -999 이상 999 이하의 정수만 입력할 수 있다.
     *
     *
     * ℹ️ 입력
     * 정수 a, b, c, d, e, f가 공백으로 구분되어 차례대로 주어진다 ( -999 <= a, b, c, d, e, f <= 999  )
     * 문제에서 언급한 방정식을 만족하는(x,y)가 유일하게 존재하고, 이떄 x 와 y가 각각 -999 이상 999이하의 정수인
     * 경우에만 입력으로 주어짐을 보장된다.
     *
     * 👍 출력
     * 문제의 답인 x와 y를 공백으로 구분하여 출력
     * 
     * */
    public static void main(String[] args) {
        try( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            int d = Integer.parseInt(arr[3]);
            int e = Integer.parseInt(arr[4]);
            int f = Integer.parseInt(arr[5]);

            // -999 ~ 999 까지의 x 값
            for( int x = -999 ; x <= 999 ; x++ ){
                // -999 ~ 999 까지의 y 값
                for( int y = -999 ; y <= 999 ; y++ ){
                    // 값 검증
                    if( a*x+b*y == c && d*x+e*y == f ){
                        bw.write(x + " " + y);
                        bw.flush();
                        break;
                    }// if
                } // for
            } // for

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
