package baekjoon.squareAndTriangle;

import java.io.*;
import java.util.StringTokenizer;

public class Q5073 {
    /**
     * 삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.
     *
     * Equilateral :  세 변의 길이가 모두 같은 경우
     * Isosceles : 두 변의 길이만 같은 경우
     * Scalene : 세 변의 길이가 모두 다른 경우
     * 단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다.
     * 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
     *
     * 세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            while(true){
                String init = br.readLine();
                if("0 0 0".equals(init)) break;
                StringTokenizer strToken = new StringTokenizer(init, " ");
                int A = Integer.valueOf(strToken.nextToken());
                int B = Integer.valueOf(strToken.nextToken());
                int C = Integer.valueOf(strToken.nextToken());

                int MAX = Math.max(A,Math.max(B,C));

                // 가장 큰수가 작은 두수의 합보다 작다면
                if(A+B+C - MAX <= MAX){
                    bw.write("Invalid");
                } else {
                    if(A == B && A == C){
                        bw.write("Equilateral");
                    } else if(A == B || A == C || B == C){
                        bw.write("Isosceles");
                    } else {
                        bw.write("Scalene");
                    }
                } // if - else
                bw.newLine();
            }//while
            bw.flush();
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
