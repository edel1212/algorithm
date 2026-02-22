package do_it.quiz.revange;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탐색_R {
    static int[][] MAP;
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0 ,0, -1, 1};
    static int N;
    static int M;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // row
        N = Integer.parseInt(st.nextToken());
        // col
        M = Integer.parseInt(st.nextToken());
        MAP = new int[N + 1][M + 1];

        // MAP init
        for(int i = 1 ; i <= N ; i++){
            char[] cA = br.readLine().toCharArray();
            for(int j = 1 ; j <= M ; j++){
                MAP[i][j] = Integer.parseInt(String.valueOf(cA[j-1] - '0'));
            } // for
        } // for

        // 1,1 좌표부터 탐색 시작
        bfs(1,1);

        // 이동 위치마다 좌표를 저장해놨기에 마지막 위치를 반환
        bw.write(String.valueOf(MAP[N][M]));
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y){
        // 방문 배열 선언
        boolean[][] visited = new boolean[N+1][M + 1];
        // 큐 선언
        Queue<int[]> queue = new ArrayDeque<>();
        // 초기 인자값 주입
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        // 큐를 전체 소모 할 때까지 너비 탐색 진행
        while(!queue.isEmpty()){
            // 저장된 xy 값을 가져옴
            int[] xyArr = queue.poll();

            // 상하좌우 4방향 탐색
            for(int i = 0 ; i < 4 ; i++){
                // 현재 입력 받은 좌표에 상하좌우 값을 더 해봄
                int nx = xyArr[0] + dx[i];
                int ny = xyArr[1] + dy[i];

                // 지도 범위 내에 포함 되는지 확인
                if(nx > 0 && nx <= N && ny > 0 && ny <= M ){
                    // 방문한적이 없고 0이 아닐 경우
                    if( !visited[nx][ny] && MAP[nx][ny] != 0 ){
                        // 다녀온 흔적 표시
                        MAP[nx][ny] = MAP[xyArr[0]][xyArr[1]] + 1;
                        // 방문 도장
                        visited[nx][ny] = true;
                        // 큐에 저장
                        queue.offer(new int[]{nx, ny});
                    } // if
                } // if
            } // for
        }// while

    }


}
