package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탐색 {
    // 두개의 dx, dy는 반복문을 통해 상,하,좌,우 를 구할 수 있음
    // 0 : 하, 1: 우, 2: 상, 3:좌
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            char[] c = stringTokenizer.nextToken().toCharArray();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = c[j] - '0';
            } // for
        } // for

        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }

    public static void bfs(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int d = 0 ; d < 4 ; d++){
                int x = current[0] + dx[d];
                int y = current[1] + dy[d];
                // 좌표가 범위 내 인지 확인
                if( x >= 0 && y >= 0 && x < N && y < M  ){
                    // 방문 여부 및 해당 위치가 1인지 확인
                    if (!visited[x][y] && map[x][y] == 1) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x,y});
                        map[x][y] = map[current[0]][current[1]] + 1;
                    } // if
                } // if
            } // for
        }// while
    }

}
