package squareAndTriangle;

import java.io.*;
import java.util.Arrays;

public class Q10101 {
    /**
     * 삼각형의 세 각을 입력받은 다음,
     *
     * 세 각의 크기가 모두 60이면, Equilateral
     * 세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
     * 세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
     * 세 각의 합이 180이 아닌 경우에는 Error
     * 를 출력하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int[] arr = new int[3];

            for(int i = 0 ; i < 3 ; i++){
                arr[i] = Integer.valueOf(br.readLine());
            }//for

            if(Arrays.stream(arr).reduce((i,j)->i+j).getAsInt() == 180){
                if(Arrays.stream(arr).allMatch(o->o == arr[0])){
                    bw.write("Equilateral");
                } else if( arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2] ) {
                    bw.write("Isosceles");
                } else{
                    bw.write("Scalene");
                }
            } else{
                bw.write("Error");
            } //if - else
            bw.flush();
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
