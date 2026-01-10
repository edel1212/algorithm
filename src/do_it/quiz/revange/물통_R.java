package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 물통_R {
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited = new boolean[200 + 1][ 200 + 1];
    static boolean[] result = new boolean[ 200 + 1 ];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] limitOfBottle = new int[3];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // A
        limitOfBottle[0] = Integer.parseInt(stringTokenizer.nextToken());
        // B
        limitOfBottle[1] = Integer.parseInt(stringTokenizer.nextToken());
        // C
        limitOfBottle[2] = Integer.parseInt(stringTokenizer.nextToken());

        bfs(limitOfBottle);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 201; i++){
            if(result[i]) sb.append(i + " ");
        } // for

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void bfs(int[] limitOfBottle){
        Queue<AB> queue = new ArrayDeque<>();
        // 첫 시작은 A,B가 0 으로 시작
        queue.offer(new AB(0,0));
        visited[0][0] = true;
        // 첫 시작 C는 가득 차 있음
        result[limitOfBottle[2]] = true;

        while(!queue.isEmpty()){
            AB current = queue.poll();
            int[] currentWatter = {current.A ,current.B, limitOfBottle[2] - (current.A + current.B)};

            // 모든 물을 부을 수 있는 경우의 수를 확인
            for(int i = 0 ; i < 6 ; i++){
                // ✅ BFS는 원본 데이터는 건들지 않는다 (스냅 샷임)
                int[] nextWater = {currentWatter[0], currentWatter[1], currentWatter[2]};

                // 받은 수 있는 물의 총 량
                int limitOfReceiverBottle = limitOfBottle[receiver[i]] - nextWater[receiver[i]];
                // 물 붓기 로직 - 이동 가능한 물의 량 ( 보내는 물의 양 ) - 어떤 상황이든 "더 작은 값"이 우리가 실제로 옮길 수 있는 '최대치'가 되기 때문
                int amount = Math.min( nextWater[sender[i]], limitOfReceiverBottle);

                // 적정량을 넘겨주고
                nextWater[sender[i]] -= amount;
                // 적정량을 받음
                nextWater[receiver[i]] += amount;

                if(!visited[nextWater[0]][nextWater[1]]){
                    visited[nextWater[0]][nextWater[1]] = true;
                    queue.offer(new AB(nextWater[0], nextWater[1]));
                    if(nextWater[0] == 0) result[nextWater[2]] = true;
                } // if
            } // for
        }// while
    }

    // A,B의 물량 저장
    public static class AB{
        int A ;
        int B ;
        public AB(int A, int B){
            this.A = A;
            this.B = B;
        }
    }
}
