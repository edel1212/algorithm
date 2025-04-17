package baekjoon.intensiveStep1;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q10812_ReTry {

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

                // 시작
                int begin = Integer.valueOf(strToken.nextToken()) - 1;
                // 끝
                int end = Integer.valueOf(strToken.nextToken()) - 1;
                // 기준
                int mid = Integer.valueOf(strToken.nextToken()) - 1;

                // 변환되며 Loop사용
                int tmpBegin = box.get(begin);
                // 기준이 될 Mid값 해당 값이 가장 처음으로 가야함
                int baseMid = box.get(mid);

                while(tmpBegin != baseMid){ // 처음값이 중간값과 같아질경우 Stop
                    box.remove(begin);          // 처음 값 삭제
                    box.add(end, tmpBegin);     // 마지막에 지워진 값 추가
                    tmpBegin = box.get(begin);  // tmp값 재설정 remove(begin)으로인해 값이 당겨짐
                }// while

            }//for

            for(int item : box){
                bw.write(String.valueOf(item));
                bw.write(" ");
            }//for
            bw.flush();
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}