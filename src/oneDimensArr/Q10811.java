package oneDimensArr;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q10811 {
    /**
     * 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있다.
     * 바구니는 일렬로 놓여져 있고, 가장 왼쪽 바구니를 1번째 바구니, 그 다음 바구니를 2번째 바구니, ...,
     * 가장 오른쪽 바구니를 N번째 바구니라고 부른다.
     *
     * 도현이는 앞으로 M번 바구니의 순서를 역순으로 만들려고 한다. 도현이는 한 번 순서를 역순으로 바꿀 때,
     * 순서를 역순으로 만들 범위를 정하고, 그 범위에 들어있는 바구니의 순서를 역순으로 만든다.
     *
     * 바구니의 순서를 어떻게 바꿀지 주어졌을 때, M번 바구니의 순서를 역순으로 만든 다음,
     * 바구니에 적혀있는 번호를 가장 왼쪽 바구니부터 출력하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));){

            StringTokenizer init = new StringTokenizer(br.readLine(), " ");

            // 바구니의 수
            int N = Integer.valueOf(init.nextToken());
            // 변경 할 횟수
            int M = Integer.valueOf(init.nextToken());

            // 바구니
            List<Integer> result = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());

            // 요청에 맞게 변경
            changeBall(M, br, result);

            // 결과 출력
            printResult(bw, result);
        } catch (IOException io){
            io.printStackTrace();
        }
    }

    private static void changeBall(int M, BufferedReader br, List<Integer> result) throws  IOException{
        StringTokenizer strToken;
        for(int i = 0 ; i < M ; i++){
            strToken = new StringTokenizer(br.readLine(), " ");
            int baseIndex   = Integer.valueOf(strToken.nextToken()) - 1;
            int targetIndex = Integer.valueOf(strToken.nextToken()) - 1;
            /**
             * 역순 변경 로직 BaseIndex는 늘리고 targetIndex는 줄여가면서
             *  - tmpNum 변수에 값을 담고 변경
             *  - k++, targetIndex--  <b>해당 부분이 핵심 로직</b>
             * */
            for(int k = baseIndex ; k <= targetIndex; k++, targetIndex--){
                int tmpNum = result.get(k);
                result.set(k, result.get(targetIndex));
                result.set(targetIndex, tmpNum);
            }//for
        }//for
    }

    private static void printResult(BufferedWriter bw, List<Integer> result) throws IOException{
        for(int i : result){
            bw.write(String.valueOf(i));
            bw.write(" ");
        };
        bw.flush();
    }

}
