package do_it.quiz;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 물통 {
    // 물통을 주고 받을때 사용할 변수 총 6번을 옮길 수 있음( 길찾기의 좌표와 같은 역할을 함 )
    // 0 : A, 1 : B, 2 : C
    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0, 2, 0, 1};

    // 방문 체크 배열 (최대 물의 용량은 200 리타 이기에 200+1 로 진행)
    // A,B 까지만 방문 저장 (C는 굳이 필요 없기에 사용하지 않음)
    static boolean[][] visited = new boolean[200+1][200+1];
    // 답을 저장할 배열 (인덱스: C물통의 물의 양, 값: 가능 여부 true/false)
    static boolean[] answer = new boolean[200+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        // 물통의 최대 용량 지정
        int[] limitBottle = new int[3];
        // A
        limitBottle[0] = Integer.parseInt(stringTokenizer.nextToken());
        // B
        limitBottle[1] = Integer.parseInt(stringTokenizer.nextToken());
        // C
        limitBottle[2] = Integer.parseInt(stringTokenizer.nextToken());

        bfs(limitBottle);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 201; i++){
            if(answer[i]) sb.append(i+ " ");
        } // for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void bfs(int[] limitBottle){
        Queue<AB> queue = new ArrayDeque<>();
        // 초기 값은 0 0 으로 시작
        queue.add(new AB(0, 0));
        // A,B 모두 0일 경우 방문 체크
        visited[0][0] = true;
        // 0,0, C 일 경우 정답 배열 추가
        answer[limitBottle[2]] = true;

        while(!queue.isEmpty()){
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            // C의 물의 양은 '전체 물의 양(Limit[2])'에서 A와 B를 뺀 값과 같음 (물은 사라지지 않음)
            int C = limitBottle[2] - A - B;

            // 모든 물 붙기 방식을 시도 해봄
            for(int i = 0 ; i < 6 ; i++){
                // 물을 옮긴 후의 A, B, C 상태를 임시로 담을 배열
                int[] next = {A, B, C};
                // 누가
                int from = Sender[i];
                int to   = Receiver[i];

                // 2. 물 옮기기 시뮬레이션

                // [경우 1] 받는 통에 여유 공간이 충분해서, 주는 쪽 물을 '몽땅' 다 부을 수 있음
                if(limitBottle[to] - next[to] >= next[from]){
                    // to 에게 몽땅 다 줘버림
                    next[to] += next[from];
                    next[from] = 0;
                } else {
                    next[from] -= (limitBottle[to] - next[to]);
                    next[to] = limitBottle[to];
                } // if - else

                // A, B 병을 방문한 적이 없다면
                if(!visited[next[0]][next[1]]){

                    // 방문 체크
                    visited[next[0]][next[1]] = true;
                    // 큐에 넣어서 다음 탐색을 이어감
                    queue.add(new AB(next[0], next[1]));

                    // 4. 정답 조건 확인
                    // 문제 조건: "첫 번째 물통(A)이 비어 있을 때"
                    if (next[0] == 0) {
                        // 그때의 세 번째 물통(C)의 양을 정답 배열에 체크
                        answer[next[2]] = true;
                    } // if
                } // if

            }// for
        } // while
    }

    // 두 물통 A, B를 저장할 Class
    // - 물통 C의 경우 A+B로 알 수 있다 (시작 물의 값은 C로만 시작)
    public static class AB{
        int A;
        int B;
        public AB(int A, int B){
            this.A = A;
            this.B = B;
        }
    }
}
