package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0}; // 행(x) 방향 → 위, 아래
    static int[] dy = {0, 0, -1, 1}; // 열(y) 방향 → 왼쪽, 오른쪽

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            // Row 값
            N = Integer.parseInt(stringTokenizer.nextToken());
            // Col 값
            M = Integer.parseInt(stringTokenizer.nextToken());

            // 미로 초기화
            map = new int[N][M];
            // 미로 값 주입
            for(int i = 0 ;  i < N ; i++){
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                } // for
            } // for


            // 미로까지의 최단 거리
            dist = new int[N][M];
            // 방문 여부
            visited = new boolean[N][M];

            bfs(0, 0);
            bw.write(String.valueOf(dist[N - 1][M - 1]));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        dist[x][y] = 1;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            // 상,하,좌,우 4가지 범위 탐색
            for (int dir = 0; dir < 4; dir++) {
                // 시작 위치에서 상, 하 , 좌, 우 값을 확인 가능함 ( 전제 조건은 0,1)로만 이뤄여 있어야함
                int nx = currentX + dx[dir];
                int ny = currentY + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 재 방문을 막고 상,하,좌,우에 길이 있을 경우
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        // 방문 등록
                        visited[nx][ny] = true;
                        // 이동한 위치에 대한 값 이동 거리 + 1
                        dist[nx][ny] = dist[currentX][currentY] + 1;
                        queue.offer(new int[]{nx, ny});
                    } // if
                } // if

            } //for
        }// while
    }

}
