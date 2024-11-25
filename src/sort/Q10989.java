package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q10989 {
    /***
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
     * - 포인트
     * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            long N = Long.parseLong(br.readLine());

            List<Long> arr = new ArrayList<>();
            for(long i = 0 ; i < N; i++ ){
                arr.add(Long.parseLong(br.readLine()));
            }// for
            arr.stream().sorted().forEach( i -> {
                try {
                    bw.write(String.valueOf(i));
                    bw.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            bw.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
