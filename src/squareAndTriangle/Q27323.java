package squareAndTriangle;

import java.io.*;

public class Q27323 {
    /**
     * 정수 A, B 가 주어진다. 세로 길이가 A cm, 가로 길이가 B cm 인 아래와 같은 직사각형의 넓이를 cm2 단위로 구하시오.
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int A = Integer.valueOf(br.readLine());
            int B = Integer.valueOf(br.readLine());
            bw.write(String.valueOf(A*B));
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
