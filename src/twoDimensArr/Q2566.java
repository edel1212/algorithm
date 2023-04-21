package twoDimensArr;

import java.io.*;
import java.util.StringTokenizer;

public class Q2566 {
    /**
     *  9×9 격자판에 쓰여진 81개의 자연수 또는 0이 주어질 때,
     *  이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.
     *
     * 예를 들어, 다음과 같이 81개의 수가 주어지면
     *
     * 첫째 줄부터 아홉 번째 줄까지 한 줄에 아홉 개씩 수가 주어진다. 주어지는 수는 100보다 작은 자연수 또는 0이다.
     *
     * 첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 위치한 행 번호와 열 번호를 빈칸을 사이에 두고 차례로 출력한다.
     * 최댓값이 두 개 이상인 경우 그 중 한 곳의 위치를 출력한다.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer strToken = null;

            // 최댓값 및 위치
            String maxNum       = "";
            StringBuilder maxPosition  = new StringBuilder();

            // 값을 비교알 변수
            int tmp = 0;
            for(int i = 0 ; i < 9 ; i++){
                strToken = new StringTokenizer(br.readLine() , " ");
                for(int j = 0 ; j < 9 ; j++){
                    int item = Integer.valueOf(strToken.nextToken());
                    if(item >= tmp){
                        tmp = item;
                        maxNum = String.valueOf(item);
                        maxPosition.setLength(0); // 초기화
                        maxPosition.append(i+1);
                        maxPosition.append(" ");
                        maxPosition.append(j+1);
                    }//if
                }//for
            }//for
            bw.write(maxNum);
            bw.newLine();
            bw.write(maxPosition.toString());
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
