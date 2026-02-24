package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 동전0_R {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for(int i = 0 ; i < N ; i++){
            coins[i] = Integer.parseInt(br.readLine());
        } // for

        for(int i = N -1 ; i >= 0 ; i--){

            // ✅ 성능 향상을 위해 나눗셈과 나머지를 사용
            if (K >= coins[i]) {
                count += (K / coins[i]); // 몫: 사용한 동전의 개수 누적
                K %= coins[i];           // 나머지: 남은 금액 갱신
            } // if

            // 4. 조기 종료 (최적화): 남은 금액이 0원이 되면 불필요한 하위 탐색 중지
            if (K == 0) break;

        } // for

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
