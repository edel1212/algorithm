package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 조약돌_꺼내기 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 조약돌 색의 종류
        int M = Integer.parseInt(br.readLine());

        // 색상별로 조약돌의 개수를 저장할 변수
        int[] pebbles = new int[M];

        int totalN = 0;
        // 전체 조약돌의 개수 확인 및 조약돌별 색상 개수 주입
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            pebbles[i] = Integer.parseInt(st.nextToken());
            // 조약돌의 전체 개수 합산
            totalN += pebbles[i];
        } // for

        // 돌을 뽑을 개수
        int K = Integer.parseInt(br.readLine());

        // DP 테이블 표 ( double로 초기화 하는 이유는 값이 어마무시하게 커지기에 long으로도 커버가 안되기 떄문이다. )
        double[][] D = new double[totalN + 1][totalN + 1];

        for (int i = 0; i <= totalN; i++) {
            D[i][0] = 1; // 0개 뽑기
            D[i][i] = 1; // 전체 다 뽑기
            D[i][1] = i; // 1개 뽑기
        } // for

        for (int i = 2; i <= totalN; i++) {
            for (int j = 2; j < i; j++) {
                D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
            } // for
        } // for

        // 전체 돌(totalN) 중에서 K개를 뽑는 모든 경우의 수
        double totalCases = D[totalN][K];

        // 같은 색끼리만 K개를 뽑은 경우의 수 합
        double sameColorCases = 0;

        for(int i = 0; i < M ; i++){
            // 뽑아야하는 조약돌의 개수보다 가지고 있는 같은색의 돌이 많을 경우만 가능함
            if(pebbles[i] >= K){
                sameColorCases += D[pebbles[i]][K];
            } // if
        } // for

        bw.write(String.valueOf(sameColorCases / totalCases));
        bw.flush();
        bw.close();
    }
}
