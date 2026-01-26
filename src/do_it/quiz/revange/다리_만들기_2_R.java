package do_it.quiz.revange;

import java.io.*;
import java.util.*;

public class 다리_만들기_2_R {
    static int[] parents;
    // 섬 번호
    static int islandNum = 0;
    // 조건에 맞는 다리 연결 정보
    static PriorityQueue<Edge> graph = new PriorityQueue<>();
    // 지도 초기 0 과 1만 있음
    static int[][] maps;
    // 상하좌우
    static int[] dr = {-1, 1 ,0 ,0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
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

        // 지도 init
        maps = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
            } // for
        } // for

        // bfs를 통해 섬 번호 주입
        visited = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 땅일 경우만 진행 + ✅ 방문 했던 곳인지 체크하는 로직이 필요함 !!!!
                if(maps[i][j] == 1 && !visited[i][j]){
                    // 섬 번호 추가 (0부터 시작함)
                    islandNum++;
                    bfs(i, j);
                } //if
            } // for
        } // for

        // 브루트 포스를 이용해서 다리를 만듦
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 섬일 경우 시작 ✅ "0"이 아닌 바다가 아닐 경우 해야해!
                if(maps[i][j] != 0){
                    makeBridge(i, j, maps[i][j]);
                }// if
            } // for
        } // for

        // root 배열 초기화
        parents = new int[islandNum + 1];
        for(int i = 0 ; i <= islandNum ; i++ ) parents[i] = i;

        int bridgeCount = 0;
        int totalBridgeLength = 0;
        // MST
        while(!graph.isEmpty()){
            Edge current = graph.poll();

            if(find(current.s) != find(current.e)){
                bridgeCount++;
                totalBridgeLength += current.w;
                union(current.s, current.e);
                if(bridgeCount == islandNum -1) break;
            }// if

        } // while

        StringBuilder sb = new StringBuilder();
        if(totalBridgeLength == 0 || bridgeCount != islandNum -1){
            sb.append("-1");
        } else {
            sb.append(totalBridgeLength);
        } // if - else

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    // BFS 섬의 번호를 지정해주는 역할 + 섬의 개수가 몇개인지 파악이 가능해짐
    public static void bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c});
        visited[r][c] = true;
        maps[r][c] = islandNum;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            // 상하 좌우
            for(int i = 0 ; i < 4 ; i++){
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];


                if( nr >= 0 && nc >= 0 && nr < N && nc < M){
                    // 방문한적이 없고 섬일 경우
                    if(!visited[nr][nc] && maps[nr][nc] == 1){
                        // 섬번호 추가
                        maps[nr][nc] = islandNum;
                        // 방문 추가
                        visited[nr][nc] = true;
                        // 큐 추가
                        queue.offer(new int[]{nr, nc});
                    } // if
                }//if

            }// for
        } // while

    }

    // 프루트 포스 모든 방향으로 다리를 뻗어 나감
    // ✅ 현재 섬번호를 빠트림 ( 전제조건 시작점과 같으면 안돼!! )
    // - 초기 nr, nc값 틀림 한칸씩 전진하려면 ++ 가 아니라 dr, dc 값을 계속 더해주면 일짜로 가잖아!!
    // - pq애 주입하는 값도 틀림 좌표를 넣어줬었음 그게 아니라 섬번호를 넣어줘야지 노드 잖아 그게 !!
    // - 바다가 아닌 섬을 만났을 경우 pq에 넣어줘야함
    public static void makeBridge(int r, int c, int nowIslandNum){
        // 상하 좌우 다리를 뻗어 나감
        for(int i = 0 ; i < 4 ; i++){
            int nr = r;
            int nc = c;
            int bridgeLength = 0;
            // 땅이 아닐 경우 skip
            if(maps[nr][nc] == 1) continue;
            while(true){
                // 일직선으로 직진
                nr += dr[i];
                nc += dc[i];

                // 지도 밖을 나갈 경우
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) break;

                // 내 자신을 만난다면
                if( maps[nr][nc] == nowIslandNum ) break;

                // 바다가 아닌 섬을 만났을 경우
                if(maps[nr][nc] != 0 ){
                    if(bridgeLength >= 2){
                        graph.add(new Edge(nowIslandNum, maps[nr][nc], bridgeLength));
                    } // if
                    break;
                } // if

                // 다리 건설
                bridgeLength++;
            }// while

        } // for
    }


    // find
    public static int find(int i){
        if(parents[i] == i) return i;
        return parents[i] = find(parents[i]);
    }

    // union
    public static void union(int a , int b){
        int rootA = find(a);
        int rootB = find(b);
        if(find(a) != find(b)){
            parents[rootA] = rootB;
        } // if
    }

    public static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int w;
        public Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
}
