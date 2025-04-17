package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1436 {
    /**
     * 종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수를 말한다. 제일 작은 종말의 수는 666이고
     * 그 다음으로 큰 수는 1666, 2666, 3666, .... 이다
     * 숌은 첫 번째 영화의 제목은 "세상의 종말 666", 두 번째 영화의 제목은 "세상의 종말 1666"와 같이 이름을 지을 것이다.
     *
     * 입력
     * 첫째 줄에 N이 주어진다. N은 10,000보다 작거나 같은 자연수이다.
     *
     * 출력
     * 첫째 줄에 N번째 영화의 제목에 들어간 수를 출력
     *
     * 2 ->  1666
     * 187 -> 66666
     * 500 -> 166699
     *
     * */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int N = Integer.parseInt(br.readLine());

            // 필수로 포함 되어야 하는 영화명
            String requiredName = "666";
            
            // 해당 문제의 포인트는 666이 포함되며 오름 차순 인것이다
            int movieSeries = 1;
            int movieNumber = 666;
            while (movieSeries != N) {
                // 영화 수 증가 
                movieNumber++;
                // 666이 포함 된다면 해당 시리즈를 올리자
                if (String.valueOf(movieNumber).contains(requiredName)) {
                    movieSeries++;
                } // if
            } // while

            bw.write(String.valueOf(movieNumber));
            bw.flush();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
