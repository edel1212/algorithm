package baekjoon.intensiveStep1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q10812_Fail {
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

            // 1 ~ N이 들어있는 바구니
            List<Integer> box = new LinkedList<>(IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList()));
            List<Integer> tmpArr1 = new ArrayList<>();
            List<Integer> tmpArr2 = new ArrayList<>();
            List<Integer> result = new ArrayList<>();

            // 위치를 바꿀 횟수
            int M = Integer.valueOf(init.nextToken());
            // 홧수만큼 반복
            for(int i = 0; i < M ; i++){
                StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");
                // 시작
                int begin = Integer.valueOf(strToken.nextToken()) - 1;
                // 끝
                int end   = Integer.valueOf(strToken.nextToken()) - 1;
                // 기준
                int mid   = Integer.valueOf(strToken.nextToken()) - 1;

                /**
                 * mid -> end -> begin 순
                 * */
                for(int j = mid; j <= end; j++){
                    tmpArr1.add(box.get(j)); // 456
                }
                for(int k = end-1; k >= begin ; k--){
                    tmpArr2.add(box.get(k)); // 321
                }
                result.addAll(tmpArr1);
                result.addAll(tmpArr2.stream().filter(data->{
                    return !tmpArr1.contains(data);
                }).collect(Collectors.toList()));
                box = result;
            }//for
            System.out.println(Arrays.toString(box.toArray()));
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
