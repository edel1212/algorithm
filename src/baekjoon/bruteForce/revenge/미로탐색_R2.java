package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_R2 {
    // 지도의 행 개수
    static int N;
    // 지도의 열 개수
    static int M;
    // 지도
    static int[][] map;
    // 미로 내 이동 값
    static int[][] dist;
    // 방문 여부
    static boolean[][] visited;

    // 상,하,좌,우 변경 변수
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(stringTokenizer.nextToken());
            M = Integer.parseInt(stringTokenizer.nextToken());

            // 미로 생성
            map = new int[N][M];
            dist = new int[N][M];
            visited = new boolean[N][M];

            // 미로 값 주입
            for(int i = 0 ;  i < N ; i++){
                String line = br.readLine();
                for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            } // for

            bfs(0,0);

            // 이동 값 가장 마지막 위치 값 반환
            bw.write(String.valueOf(dist[N - 1][M - 1]));
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        dist[x][y] = 1;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 상하좌우 4가지 방향 loop
            for(int dir = 0 ; dir < 4; dir++){
                // x값 이동
                int nx = cx + dx[dir];
                // y 값 이동
                int ny = cy + dy[dir];

                // 지도 범위 내의 좌표인지 획인
                if( 0 <= nx && 0 <= ny && nx < N && ny < M  ){
                    // 방문한 적이 없고 갈 수 있는 곳 일 경우
                    if(!visited[nx][ny] && map[nx][ny] == 1){
                        visited[nx][ny] = true;
                        dist[nx][ny] =  dist[cx][cy] + 1;
                        queue.offer(new int[]{nx, ny});
                    } // if
                } // if

            } // for

        } // while
    }

}
