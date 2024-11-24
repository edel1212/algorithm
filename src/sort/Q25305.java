package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q25305 {
    /**
     * 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에
     * N명의 학생들이 응시했다.
     * 이들 중 점수가 가장 높은
     * k명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
     * 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.
     *
     * 입력
     * 첫째 줄에는 응시자의 수
     * N과 상을 받는 사람의 수
     * k가 공백을 사이에 두고 주어진다.
     *
     * 둘째 줄에는 각 학생의 점수
     * x가 공백을 사이에 두고 주어진다.
     *
     * 출력
     * 커트타인
     *
     * */
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer str = new StringTokenizer(br.readLine(), " ");

            // 응시자 수
            int N = Integer.parseInt(str.nextToken());
            // 상 받을 사람 수
            int k = Integer.parseInt(str.nextToken());

            // 학생들의 점수등
            int[] arr = new int[N];

            str = new StringTokenizer(br.readLine(), " ");

            for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(str.nextToken());

            int[] sortedArr = Arrays.stream(arr)
                    .boxed() // int를 Integer로 변환
                    .sorted(Comparator.reverseOrder()) // 내림차순 정렬
                    .mapToInt(Integer::intValue) // Integer를 다시 int로 변환
                    .toArray();

            // 상 받을 사람의 가장 낮은 수
            bw.write(String.valueOf(sortedArr[k-1]));
            bw.flush();


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
