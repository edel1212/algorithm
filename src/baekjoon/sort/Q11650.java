package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Q11650 {
    /***
     * 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
     *
     * 입렵
     * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
     *
     * 출력
     * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
     * @param args
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(stringTokenizer.nextToken()); // 각 값을 배열에 저장
                arr[i][1] = Integer.parseInt(stringTokenizer.nextToken()); // 각 값을 배열에 저장
            }// for

            List<int[]> result = Arrays.asList(arr).stream().sorted( (row1, row2) ->{
                if(row1[0] == row2[0]){
                    return Integer.compare(row1[1],row2[1]);
                }// if
                return Integer.compare(row1[0], row2[0]);
            } ).collect(Collectors.toList());

            for(int[] i : result){
                bw.write(i[0]+ " " + i[1]);
                bw.newLine();
            }//for
            bw.flush();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
