package do_it.quiz.revange;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_R3 {
    static int N;
    static int M;
    // 우,상,좌,하
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            char[] c = stringTokenizer.nextToken().toCharArray();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = c[j] - '0';
            } // for
        } // for
        visited = new boolean[N][M];

        bfs(0,0);

        bw.write(String.valueOf(map[N-1][M-1]));
        bw.flush();
        bw.close();
    }


    public static void bfs(int i , int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            // 상하 좌우 4방위 탐색
            for(int d = 0 ; d < 4 ; d++){
                int x = current[0] + dx[d];
                int y = current[1] + dy[d];

                // 범위 내 포함 여부 확인
                if( x >= 0 && x < N  && y >= 0 && y < M ){

                    // 방문 여부 및 이동하려는 곳이 1인지 확인
                    if(!visited[x][y] && map[x][y] == 1){
                        queue.offer(new int[]{x,y});
                        visited[x][y] = true;
                        // 이동 거리 누적
                        map[x][y] = map[current[0]][current[1]] + 1;
                    }  // if
                } // if

            } // for

        } // while
    }

}
