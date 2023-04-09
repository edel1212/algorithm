package oneDimensArr;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q10813 {
    public static void main(String[] args) {

        /**
         * 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다.
         * 바구니에는 공이 1개씩 들어있고, 처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있다.
         * 도현이는 앞으로 M번 공을 바꾸려고 한다. 도현이는 공을 바꿀 바구니 2개를 선택하고, 두 바구니에 들어있는 공을 서로 교환한다.
         * 공을 어떻게 바꿀지가 주어졌을 때, M번 공을 바꾼 이후에 각 바구니에 어떤 공이 들어있는지 구하는 프로그램을 작성하시오.
         * */

        try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); ){

            StringTokenizer init = new StringTokenizer(br.readLine());

            // 바구니 개수
            int N = Integer.valueOf(init.nextToken());
            // 공을 바꿀 횟수
            int M = Integer.valueOf(init.nextToken());

            // 바구니 개수만큼 배열 생성 및 각각의 번호에 맞는 숫자 추가
            List<Integer> result = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());

            // 공의 위치 변경
            changeBoxBall(M, br, result);

            //결과 값 작성
            printResult(result, bw);

        } catch (IOException io){
            io.printStackTrace();
        }

    }

    private static void changeBoxBall(int M, BufferedReader br, List<Integer> result) throws IOException{
        // 임시 저장 변수
        int tmpNum = 0;
        StringTokenizer strToken = null;
        for(int i = 0 ; i < M ; i++){
            strToken = new StringTokenizer(br.readLine());
            // 바뀔 대상
            int baseBoxIndex   = Integer.valueOf(strToken.nextToken()) - 1;
            // 바뀔 대상
            int targetBoxIndex = Integer.valueOf(strToken.nextToken()) - 1;

            //변경
            tmpNum = result.get(baseBoxIndex);
            result.set(baseBoxIndex   , result.get(targetBoxIndex));
            result.set(targetBoxIndex , tmpNum);
        }//for
    }

    private static void printResult(List<Integer> result,BufferedWriter bw) throws IOException{
        for(Integer i : result ){
            bw.write(String.valueOf(i));
            bw.write(" ");
        }//for
        bw.flush();
    }
}
