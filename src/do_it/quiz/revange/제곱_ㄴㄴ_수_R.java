package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 제곱_ㄴㄴ_수_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strToken = new StringTokenizer(br.readLine());
        long min = Long.parseLong(strToken.nextToken());
        long max = Long.parseLong(strToken.nextToken());

        boolean[] isNotSquares = new boolean[ (int) (max - min + 1) ];

        // 제곱근 시작 값 반복문
        for(long i = 2 ; i * i <= max; i++){
            // 제곱근
            long square = i * i;

            // 제곱근의 곱할 수를 구함
            long start = min / square;
            // 나눠 떨어지지 않을 경우 시작값을 1추가 -> 10 / 4 => 2 따라서 3으로 시작
            if(min % square != 0) start++;

            // 제곱근 처리
            for(long j = start ; square * j <= max ; j++){
                // start를 구하는 공식 덕분에 -min을 하여도 음수가 나오지 않음
                isNotSquares[ (int) (square * j - min)  ] = true;
            } // for

        } // for

        int count = 0;
        for(int i = 0 ; i < isNotSquares.length; i++ ){
            if(!isNotSquares[i]) count++;
        } // for

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
