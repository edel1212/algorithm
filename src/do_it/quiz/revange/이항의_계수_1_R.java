package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 이항의_계수_1_R {
    static int N;
    static int K;
    static int[][] D;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = new int[N + 1][N + 1];

        // 점화식 초기화
        for(int i = 0 ; i <= N ;i++){
            D[i][0] = 1; // i 개중 0개 뽑기 => 1가지 ( i명 중에서 0명을 뽑는 방법의 수 - 아무것도 안 뽑는 경우 1가지 경우의 수 밖에 없음 )
            D[i][i] = 1; // i 개중 i개 뽑기 => 1가지 ( i명 중에서 i명을 모두 뽑는 방법 - 전부를 다 뽑는 경우은 1가지 경우의 수 밖에 없음 )
            D[i][1] = i; // i 개중 1개 뽑기 => i가지 ( i명중 1명을 뽑는 방법 - i명 중 한 명을 고르는 방법은 당연히 i가지 )
        } // for

        // 점화식 도출
        // 효율성을 위함 양 끝 벽(0번째, i번째)은 이미 1로 채워놨으니까, 2행부터 시작해서 그 사이의 빈칸(1 ~ i-1)만 채우는 것이 효율적
        // 직각 삼각형을 생각하면 된다 (벽면을 제외한 내부를 채운다)
        for(int i = 2 ; i <= N  ;i++){
            for (int j = 1; j < i; j++){
                D[i][j] = D[i - 1][j - 1] + D[i-1][j];
            } // for
        } // for

        bw.write(String.valueOf(D[N][K]));
        bw.flush();
        bw.close();
        br.close();
    }
}
