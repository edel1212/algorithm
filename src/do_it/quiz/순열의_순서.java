package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;
//  1722번 , 1256번, 1794번
public class 순열의_순서 {
    static final int LIMIT = 20;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수의 범위 (N의 최대 값은 20)
        int N = Integer.parseInt(br.readLine());

        // 팩토리얼 값을 미리 구해 놓음
        long[] F = new long[LIMIT + 1];
        F[0] = 1;
        for(int i = 1 ; i <= LIMIT ; i++){
            F[i] = F[i-1] * i;
        } //for

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1일 경우 k 번째 배열 수, 2일 경우 지정 배열의 위치 값
        int type = Integer.parseInt(st.nextToken());

        // 방문 여부 체크용
        boolean[] visited = new boolean[LIMIT + 1];

        if(type == 1){
            int[] result = new int[N];
            // ✅ 찾고자 하는 배열의 index (Long으로 선언 이유는 N!로 값이 구해지기 때문임)
            long K = Long.parseLong(st.nextToken());
            // 0번째 부터
            for(int i = 0 ; i  < N ; i++){
                // 내 뒷칸을 확인 하는 것임 (N이 4일 경우 : 4 - 1 - 0 = 3!)
                long blockSize = F[N - 1 - i];
                // 1로 채워 나감
                for(int j = 1; j <= N ; j++){
                    if(visited[j]) continue;
                    if(K <= blockSize){
                        result[i] = j;
                        visited[j] = true;
                        // continue; << 이거 아니야
                        // ✅구했으면 다음 단계로 넘어가하므로 break를 사용!
                        break;
                    }// if

                    // 범위에 없다면 값을 통째로 스킵
                    K -= blockSize;
                }// for
            } // for

            // 결과 출력
            for(int  i = 0 ; i < N ; i++){
                bw.write(result[i] + " ");
            } // for
        } else{
            // ✅ 나를 포함하여 1로 시작해야함
            long ans = 1;
            // 입력 받은 배열
            int[] A = new int[N];
            for(int i = 0 ; i < N ; i++){
                A[i] = Integer.parseInt(st.nextToken());
            } // for

            // 첫번째 배열 값 부터 비교
            for(int i = 0 ; i < N ; i++){
                // 첫번째 배열과 입력 받은 배열의 값 비교
                for(int j = 1 ; j < A[i]; j++){
                    // 해당 값을 사용했는지 확인
                    if(visited[j]) continue;
                    // 나보다 앞서 있는 순열들의 개수(건너뛴 개수)를 누적
                    ans += F[ N - 1 - i];
                }// for
                // ✅ 이번 자리에 사용된 숫자(A[i])는 방문 처리 필수
                visited[A[i]] = true;
            }// for

            bw.write(String.valueOf(ans));
        } // if - else

        bw.flush();
        bw.close();
    }
}
