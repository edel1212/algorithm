package baekjoon.bruteForce.revenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_R {

    // 상하좌우를 계산가 위해 사용될 변수
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int N;
    static int M;
    public static void main(String[] args){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            // bfs를 사용해서 물어야함 - 위치로 이동할 때 최소의 칸 수를 구해야하기 때문임
            StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(strToken.nextToken());
            M = Integer.parseInt(strToken.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            dist = new int[N][M];
            for(int i = 0 ; i < N ; i++){
                String line = br.readLine();
                for(int j = 0 ; j < M; j++ ){
                    // ascii code 범위 내기에 해당 방식 사용
                    map[i][j] = line.charAt(j) - '0';
                } // for
            } // for

            bfs(0,0);
            // 거리 배열 내 가장 마지막 위치 값 반환
            bw.write(String.valueOf(dist[N -1][ M - 1]));
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        // 초기 실행 값 queue 삽입
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        dist[x][y] = 1;
        while(!queue.isEmpty()){
            int currentPosition[] = queue.poll();
            int cx = currentPosition[0];
            int cy = currentPosition[1];
            // 상하좌우 확인 후 진행
            for(int d = 0 ; d < 4 ; d++){
                // 더하는게 아닌 빼는 것임
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                // 신규 계산하려는 좌표의 범위 확인
                if( nx >= 0 && ny >= 0 && nx < N && ny < M  ){
                    // 새로운 경로 값 방문 여부와 길이 맞는지 확인
                    if(!visited[nx][ny] && map[nx][ny] == 1 ){
                        visited[nx][ny] = true;
                        // 접근 가능한 거리를 이전 이동 거리 값에서 +1 해줌
                        dist[nx][ny] = dist[cx][cy] + 1;
                        queue.offer(new int[]{nx, ny});
                    } // if
                } // if

            } // for
        } // while
    }

}
