package squareAndTriangle;

import java.io.*;
import java.util.StringTokenizer;

public class Q1085 {
    /**
     * 한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다.
     * 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer init = new StringTokenizer(br.readLine(), " ");

            // 한수의 위치
            int x = Integer.valueOf(init.nextToken());
            int y = Integer.valueOf(init.nextToken());

            // 사각형 오른쪽 끝위치
            int w = Integer.valueOf(init.nextToken());
            int h = Integer.valueOf(init.nextToken());

            // 각각의 경계선은 0 ~ w, h 이다. 그러므로
            // 0일경우는 현재 위치 만큼만 되돌이기면 됨
            int withMin   = Math.min( x , w -x );
            int heightMin = Math.min( y , h -y );

            bw.write(String.valueOf(Math.min(withMin, heightMin)));
            bw.flush();
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
