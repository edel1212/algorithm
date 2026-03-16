package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 물통_R2 {
    // A : 0 , B : 1, C : 2 ( 모든 방향에 물을 옮겨봄 )
    static int[] SENDER = {0, 0, 1, 1, 2, 2};
    static int[] RECEIVER = {1, 2, 0, 2, 0, 1};

    // 물동
    static int[] LIMIT_BOTTLES = new int[3];

    // A가 비어 있을 경우 C의 물의 결과 값 저장 (해싱 기법 사용)
    static boolean[] result = new boolean[201];
    // 방문 확인
    static boolean[][] visited = new boolean[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // A
        LIMIT_BOTTLES[0] = Integer.parseInt(st.nextToken());
        // B
        LIMIT_BOTTLES[1] = Integer.parseInt(st.nextToken());
        // C
        LIMIT_BOTTLES[2] = Integer.parseInt(st.nextToken());

        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <= 200 ; i++){
            if(result[i]) sb.append(i).append(" ");
        } // for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(){
        Deque<Bottle_A_B> queue = new ArrayDeque<>();
        queue.offer(new Bottle_A_B(0, 0));
        // 초기 A, B 가 각각 0일 경우
        visited[0][0] = true;
        // 결과 물의 양 true 처리
        result[LIMIT_BOTTLES[2]] = true;

        while(!queue.isEmpty()){
            Bottle_A_B current = queue.poll();
            int A = current.A;
            int B = current.B;
            int C = LIMIT_BOTTLES[2] - A - B;


            // 물 부어보기 시작
            for(int i = 0 ; i < 6 ; i++){
                // 임시 물을 저장할 배열 생성
                int[] tmp = { A, B, C };

                // 받을 수 있는 최대양 ( 쵀대 병의 량 - 현재 병의 물의 량 )
                int receiverLimit = LIMIT_BOTTLES[ RECEIVER[i] ] - tmp[ RECEIVER[i] ];
                // 전달 할 수 있는 량은 전부 다 주거나 혹은 줄 수 있는 최소한의 양 만큼만 주는 것이다.
                // tmp[ SENDER[i] 가 받을 수 있는 병보다 크면 병의 최대 용량 만큼만 주면됨
                int sendWaterAmount =  Math.min(  tmp[ SENDER[i] ], receiverLimit );

                // 물을 옮김
                tmp[ SENDER[i] ] -= sendWaterAmount;
                // 물을 받음
                tmp[ RECEIVER[i] ] += sendWaterAmount;

                // 방문 여부 체크는 A, B 두개의 병만 진행
                if( !visited[ tmp[0] ][ tmp[1] ] ){
                    visited[ tmp[0] ][ tmp[1] ] = true;
                    queue.offer(new Bottle_A_B( tmp[0], tmp[1] ));

                    // A가 0 일 경우 갑 지정
                    if(tmp[0] == 0) result[ tmp[2] ] = true;

                } // if


            } // for

        }// while
    }

    private static class Bottle_A_B{
        int A, B;

        public Bottle_A_B(int a, int b) {
            A = a;
            B = b;
        }
    }
}
