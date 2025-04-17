package baekjoon.intensiveStep1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q10812_Succ {
    /**
     * 도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있다.
     * 바구니는 일렬로 놓여져 있고, 가장 왼쪽 바구니를 1번째 바구니,
     * 그 다음 바구니를 2번째 바구니, ...,
     * 가장 오른쪽 바구니를 N번째 바구니라고 부른다.
     *
     * 도현이는 앞으로 M번 바구니의 순서를 회전시키려고 만들려고 한다.
     * 도현이는 바구니의 순서를 회전시킬 때, 순서를 회전시킬 범위를 정하고,
     * 그 범위 안에서 기준이 될 바구니를 선택한다.
     * 도현이가 선택한 바구니의 범위가 begin, end이고,
     * 기준이 되는 바구니를 mid라고 했을 때,
     * begin, begin+1, ...,
     * mid-1, mid, mid+1, ...,
     * end-1, end 순서로 되어있는
     * 바구니의 순서를 mid, mid+1, ..., end-1, end, begin, begin+1, ..., mid-1로 바꾸게 된다.
     *
     * 바구니의 순서를 어떻게 회전시킬지 주어졌을 때,
     * M번 바구니의 순서를 회전시킨 다음,
     * 바구니에 적혀있는 번호를 가장 왼쪽 바구니부터 출력하는 프로그램을 작성하시오.
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer init = new StringTokenizer(br.readLine());

            // 바구니의 개수
            int N = Integer.valueOf(init.nextToken());
            // 반복 횟수
            int M = Integer.valueOf(init.nextToken());

            // 1 ~ N이 들어있는 바구니
            List<Integer> box = new LinkedList<>(IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList()));

            // 홧수만큼 반복
            for(int i = 0; i < M ; i++) {
                StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");
                /**
                 * ⭐️ 받아온 Index 값은 바뀌지 않음
                 * */
                // 시작
                int begin = Integer.valueOf(strToken.nextToken()) - 1;
                // 끝
                int end = Integer.valueOf(strToken.nextToken()) - 1;
                // 기준
                int mid = Integer.valueOf(strToken.nextToken()) - 1;

                // box의 시작값  [ 값을 임시저장하여 이동 ]
                int tmpBeginVal = box.get(begin);
                /**
                 * box의 중간값  [ 비교 대상이 될것임  ]
                 * -
                * */
                int midVal = box.get(mid);

                /**
                 *  ⭐️ 시작값 과 중간값이 같지 않다면 Loop
                 *  - 💬 이유 ?
                 *   - 시작 지정값이 한개씩 지워진다.
                 *   - 중간 값이 지정한 처음으로 가야한다.
                 *
                 *   ex)  입력 >> 6 1
                 *               1 6 4
                 *
                 *      Step1  : 1 2 3 4 5 6 << 1 ~ 6까지 생성
                 *      Step2  : 시작값 1, 중간값 4 , 마지막값 6
                 *      ... 아래 코드 확인
                 *      Result : 4 5 6 1 2 3 로 만들기를 원함
                 * */
                while(tmpBeginVal != midVal){
                    /** 입력받은 시작 List.get(Index) 삭제
                     *  Step3 :  첫번째 값 삭제
                     * */
                    box.remove(begin);
                    /** 입력받은 시작 List.get(Index)값을 마지막 인덱스에 추가
                     *  Step4 :  마지막 Index에 첫번째 값 삽입
                     *           👉 첫번째 값은 tmpBeginVal에 답아 뒀음
                     * */
                    box.add(end, tmpBeginVal);
                    /**
                     * tmpBeginVal 값을 변경
                     * Step5 : 상단에서 box.remove(begin);
                     *         사용으로 지정된 첫번째 값은 기존 앞에 값임
                     * ex)
                     *     1, 2, 3 ...
                     *     2, 3, 1 ...
                     *     3, 1, 2 ...
                     *
                     *    이런식으로 줄여가다보면
                     *    mid 값과 같은 순간이 오며 순서가 바뀌어있음
                     * */
                    tmpBeginVal = box.get(begin);
                }//whie
            }
            for(int item : box){
              bw.write(String.valueOf(item));
              bw.write(" ");
            }
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
