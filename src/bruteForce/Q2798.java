package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2798 {
    /**
     * 카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서,
     * 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
     *
     * 한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
     *
     * 김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다.
     * 그런 후에 딜러는 숫자 M을 크게 외친다.
     *
     * 이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에,
     * 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
     *
     * N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
     * **/
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer strToken = new StringTokenizer(br.readLine()," ");

            // 카드의 개수
            int N = Integer.valueOf(strToken.nextToken());
            // 맞추거나 가까워야 하는 수
            int M = Integer.valueOf(strToken.nextToken());

            int[] tmp = new int[N];

            strToken = new StringTokenizer(br.readLine()," ");
            // 카드의 수만큼 Loop
            for(int i = 0; i < N ; i ++){
                tmp[i] = Integer.valueOf(strToken.nextToken());
            }//for

            bw.write(String.valueOf(search(tmp, N,M)));
            bw.flush();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    static int search(int[] arr, int N, int M){
        int result = 0;

        /**
         * 시작을 N-2를 해주는 이유는 카드를 총 3장을 뽑기 때문이다.
         *  - 그렇다면 5장일 경우에는 ? -4로 시작한다
         *  👉 그 이유?
         *  예를 들어
         *  5장의 카드를 주고 3장을 뽑는다 치면
         *  5 6 7 8 9
         *
         *  순회 예시
         *
         * 첫번쨰 For : 5
         * 두번쨰 For :: 6
         * 세번쨰 For ::: 7
         * 세번쨰 For ::: 8
         * 세번쨰 For ::: 9
         * 두번쨰 For :: 7
         * 세번쨰 For ::: 8
         * 세번쨰 For ::: 9
         * 두번쨰 For :: 8
         * 세번쨰 For ::: 9
         *
         * 첫번쨰 For : 6
         * 두번쨰 For :: 7
         * 세번쨰 For ::: 8
         * 세번쨰 For ::: 9
         * 두번쨰 For :: 8
         * 세번쨰 For ::: 9
         *
         * 첫번쨰 For : 7
         * 두번쨰 For :: 8
         * 세번쨰 For ::: 9
         * */
        // 총 3개의 카드를 고름 - 첫번째 카드만 사용하여 순회하기에 "N - 2"
        for(int i = 0 ; i < N-2 ; i++){

            // 두번째 카드는  첫 번째 카드 다음부터 "N - 1" [ 상위 For문의 + 1 로 시작 ]
            for (int j = i + 1; j < N - 1; j++) {
                // 세 번째 카드는 두 번째 카드 다음부터 N 까지 순회 [ 상위 For문의 + 1 로 시작 ]
                for (int k = j + 1; k < N; k++) {
                    // 3개의 카드를 덧셈한 수
                    int tmp = arr[i] + arr[j] + arr[k];

                    // M과 같거나 가장 가까운 수
                    if(tmp <= M && tmp > result) result = tmp;

                }//for

            }//for

        }//for

        return result;
    }

}
