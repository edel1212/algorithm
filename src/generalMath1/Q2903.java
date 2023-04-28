package generalMath1;

import java.io.*;

public class Q2903 {
    /**
     * 알고리즘을 시작하면서 상근이는 정사각형을 이루는 점 4개를 고른다. 그 후에는 다음과 같은 과정을 거쳐서 지형을 만든다.
     *
     * 정사각형의 각 변의 중앙에 점을 하나 추가한다.
     * 정사각형의 중심에 점을 하나 추가한다.
     * 초기 상태에서 위와 같은 과정을 한 번 거치면 총 4개의 정사각형이 새로 생긴다. 이와 같은 과정을 상근이가 만족할 때 까지 계속한다.
     *
     * 상근이는 어떤 점은 한 개 보다 많은 정사각형에 포함될 수 있다는 사실을 알았다. 메모리 소모량을 줄이기 위해서 중복하는 점을 한 번만 저장하려고 한다.
     * 과정을 N번 거친 후 점 몇 개를 저장해야 하는지 구하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int loopCnt = Integer.valueOf(br.readLine());

            // 4개의 점을 가진 사각현의 한변의 점의 개수
            int baseNum = 2;

            // 추가되는 점의 개수
            double cnt = 0;

            // 2의 제곱으로 하나씩 추가해주면 된다.
            for(int i = 0; i < loopCnt ;i++){
                cnt += Math.pow(baseNum, Double.valueOf(i));
            }//for

            // 기준점과 2의제곱한 횟수를 더해줌
            int plusBaseNumAndCnt = (int) (baseNum + cnt);

            // 점의 개수를 구해준다 가로개수 x 세로 개수
            String result = String.valueOf(plusBaseNumAndCnt * plusBaseNumAndCnt);

            bw.write(result);
            bw.flush();

        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
