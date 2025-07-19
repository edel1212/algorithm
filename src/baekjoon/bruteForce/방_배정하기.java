package baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 방_배정하기 {

    static boolean[] visited;
    static boolean flag = false;
    static int peopleCount;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            StringTokenizer  stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int[] rooms = new int[3];
            for(int i = 0 ; i < 3 ; i++) rooms[i] = Integer.parseInt(stringTokenizer.nextToken());
            peopleCount = Integer.parseInt(stringTokenizer.nextToken());
            visited = new boolean[peopleCount + 1];

            dfs(rooms,0);
            bw.write( flag ? "1" : "0" );
        } catch (Exception e){
            e.printStackTrace();
        } // try - catch
    }


    public static void dfs(int[] rooms, int sum){
        // 총 인원보다 합이 커지거나 방문했을 경우
        if( peopleCount < sum || visited[sum]) return;
        if (sum == peopleCount){
            flag = true;
            return;
        }  // if
        visited[sum] = true;
        for (int room : rooms) {
            dfs(rooms, sum + room);
            if (flag) return;
        }
    }

}
