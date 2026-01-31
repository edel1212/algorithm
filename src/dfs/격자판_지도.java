package dfs;


import java.io.*;
import java.util.*;

public class 격자판_지도 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static List<Integer> result = new ArrayList<>();
    static boolean[][] visited;
    static int islandNum = 0;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < N ; j++){
                // '0'(문자 0)의 아스키코드 값을 빼주면 자동으로 정수 0~9가 됩니다. 코테 필수 테크닉입니다.
                map[i][j] = line.charAt(j) - '0';
            }// for
        }// for


        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    islandNum++;
                    int count = dfs(i,j);
                    result.add(count);
                } // if
            }// for
        }// for

        // 오름 차순 정렬
        Collections.sort(result);

        bw.write(String.valueOf(result.size()));
        bw.newLine();

        for(int item : result){
            bw.write(String.valueOf(item));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();

    }

    public static int dfs(int r, int c){
        int count = 1;
        visited[r][c] = true;
        for(int i = 0 ; i < 4 ; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            // 좌표 내 있을 경우
            if( nr >= 0 && nc >= 0 && nr < N && nc < N ){
                if(!visited[nr][nc] && map[nr][nc] != 0){
                    map[nr][nc] = islandNum;
                    count += dfs(nr, nc);
                } // if
            } // if
        } // for
        return count;
    }

}

