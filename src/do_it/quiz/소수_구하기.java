package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 소수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 시작 수
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(stringTokenizer.nextToken());
        // 종료 수
        int E = Integer.parseInt(stringTokenizer.nextToken());

        // 배열 생성
        int[] A = new int[E + 1];

        // 2부터 시작하여 배열 생성 (0, 1은 소수가 될 수 없음)
        for(int i = 2 ; i <= E ;i++){
            A[i] = i;
        } // for

        // 제곱근까지만 시행
        int limit = (int) Math.sqrt(E);
        for(int i = 2 ; i <= limit; i++){

            // 0일 경우 skip (제거된 값을 0으로 바꿔 놓기 때문임)
            if(A[i] == 0){
                continue;
            } // if

            // i * i 부터 E 까지 한번 실행때마다 배수를 더함 (배수를 지움)
            for(int j = i * i; j <= E; j += i){
                A[j] = 0;
            }// for

        } // for

        for(int i = S; i<= E; i++){
            if(A[i] != 0){
                bw.write(String.valueOf(A[i]));
                bw.newLine();
            }  //if
        } // for

        bw.flush();
        bw.close();
    }
}
