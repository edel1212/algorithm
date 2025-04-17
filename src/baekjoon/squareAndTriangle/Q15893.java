package baekjoon.squareAndTriangle;

import java.io.*;

public class Q15893 {
    /**
     * "한 변의 길이가 1인 정사각형을 아래 그림과 같이 겹치지 않게 빈틈없이 계속 붙여 나간다.
     * 가장 아랫부분의 정사각형이 n개가 되었을 때, 실선으로 이루어진 도형의 둘레의 길이를 구하시오."
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            Long n = Long.valueOf(br.readLine());
            bw.write(String.valueOf(n * 4));
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
