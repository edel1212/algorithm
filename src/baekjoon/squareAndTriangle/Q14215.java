package baekjoon.squareAndTriangle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14215 {
    /**
     * 영선이는 길이가 a, b, c인 세 막대를 가지고 있고, 각 막대의 길이를 마음대로 줄일 수 있다.
     *
     * 영선이는 세 막대를 이용해서 아래 조건을 만족하는 삼각형을 만들려고 한다.
     *
     * 각 막대의 길이는 양의 정수이다
     * 세 막대를 이용해서 넓이가 양수인 삼각형을 만들 수 있어야 한다.
     * 삼각형의 둘레를 최대로 해야 한다.
     * a, b, c가 주어졌을 때, 만들 수 있는 가장 큰 둘레를 구하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");
            int a = Integer.valueOf(strToken.nextToken());
            int b = Integer.valueOf(strToken.nextToken());
            int c = Integer.valueOf(strToken.nextToken());

            int max = Math.max(a,Math.max(b,c)); // Max

            // Max를 제외한 나머지를 더 한 값
            int tmpNum = a + b + c - max;

            // 삼각형 공식에 따라 가장 큰 변이 나머지 두변보다 크거나 같으면 안된다.
            if(max >= tmpNum ){
                // 가장 넓은 둘래를 원했으니 가장 큰값을 줄여나감
                // - 줄이는 최대값은 나머지 두변수를 더한값 -1을 해주면 최대 둘래가 나옴
                bw.write(String.valueOf(tmpNum * 2 - 1));
            } else{
                // 아닐 경우 그냥 다 더해주면 된다.
                bw.write(String.valueOf(a+b+c));
            }
            bw.flush();
        }catch (Exception io){
            io.printStackTrace();
        }
    }
}
