package bruteForce;

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

            String defaultMovieName = "666";
            if(N >= 2) defaultMovieName = (N-1) + defaultMovieName;

            bw.write(defaultMovieName);
            bw.flush();

            // 187 -> 66666

            // 186 ->

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
