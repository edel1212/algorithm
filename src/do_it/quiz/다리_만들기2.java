package do_it.quiz;

import java.io.*;
import java.util.*;

public class 다리_만들기2 {

    // 지도상 상,하,좌,우 를 이동할때 사용할 변수
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0 ,-1, 1};
    // 세로 길이
    static int N ;
    // 가로 길이
    static int M ;
    // 지도
    static int[][] map;
    static boolean[][] visited;
    // 섬 식별 번호
    static int islandNum = 0;
    // 다리(간선) 기준ㄴ 정보를 담을 우선순위 큐(거리가 짧으 순 정렬)
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    // union-find에 사용될 Root 노드 배열
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 세로값 주입
        N = Integer.parseInt(st.nextToken());
        // 가로값 주입
        M = Integer.parseInt(st.nextToken());
        // 지도 초기화
        map = new int[N][M];
        // 방문 변수 초기화
        visited = new boolean[N][M];

        // 지도 데이터 주입
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            } //for
        } //for

        // ✅ 1. [BFS] 현재 지도는 0, 1 (땅, 바다)로만 이뤄쟈 있기에 섬을 구분할 수 없기에 BFS를 통해 섬에 번호를 붙여줌
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 땅 이면서, 방문한적이 없어야함
                if(map[i][j] == 1 && !visited[i][j]){
                    // 섬 식별 번호 추가
                    islandNum++;
                    bfs(i, j);
                } //if
            }// for
        }// for


        // ✅ 2. [Brute Force] 지도의 모든 땅에서 4방향으로 다리 놓기
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                makeBridge(i, j, map[i][j]);
            } //for
        } //for


        // ✅ 3. [MST] 찻아낸 다리중 가장 짧은 것부터 연결 시도
        // union-find 초기값 init (섬의 개수만큼)
        parent = new int[islandNum + 1];
        for(int i = 1 ; i <= islandNum ; i++){
            parent[i] = i;
        } // for

        // 총 다리길이
        int totalLength = 0;
        // 연결된 다리 개수
        int bridgeCount = 0;

        // 조건에 맞는 다리 연결들 확인
        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            // 합칠 수 있을 경우 다리 건설
            if(find(edge.s) != find(edge.e)){
                union(edge.s, edge.e);
                totalLength += edge.w;
                bridgeCount++;
            } //if

        } // while

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        if(totalLength == 0 || bridgeCount != islandNum -1){
            sb.append("-1");
        } else {
            sb.append(totalLength);
        } // if - else

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 유니온 파인드 - find
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // 유니온 파인드 - union
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }// if
    }

    // BFS
    public static void bfs(int row , int col){
        Queue<int[]> queue = new LinkedList<>();
        // 초기 BFS 값 주입
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        map[row][col] = islandNum;

        // 인접 대상 Search
        while(!queue.isEmpty()){
            int[] current = queue.poll();

            // 상,하,좌,우 탐색
            for(int i = 0; i < 4 ; i++){
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                // 지도 범위 내 인지 확인
                boolean isNotOutByLeftAndTop = nr >= 0 && nc >= 0;
                boolean isNotOutByRightAndBottom = nr < N && nc < M;
                if(isNotOutByLeftAndTop && isNotOutByRightAndBottom){

                    // 방문 여부 및 섬인지 확인 (섬일 경우 위치가 "1")
                    if(!visited[nr][nc] && map[nr][nc] == 1){
                        // 방문 처리
                        visited[nr][nc] = true;
                        // 섬 번호 부여
                        map[nr][nc] = islandNum;
                        // queue 값 주입
                        queue.offer(new int[]{nr, nc});
                    } //if

                }// if

            }// for

        }// while

    }

    // 한 지점에서 4방향의 다리를 모두 뻗어봄 (부르트 포스)
    public static void makeBridge(int row, int col, int nowIslandNum){
        // 상하좌우 조회
        for(int i = 0 ; i < 4 ; i++){
            // 다리 길이
            int bridgeLength = 0;
            // 이동 예정 좌표 초기화
            int nr = row;
            int nc = col;

            while(true){
                // 한칸씩 전진
                nr += dr[i];
                nc += dc[i];

                // 지도 밖을 나갈 경우 제외
                if( nr < 0 || nc < 0 || nr >= N || nc >= M ) break;

                // 다리를 이을 때 내 자신과 만난다면 제외
                if( map[nr][nc] == nowIslandNum ) break;

                // 바다가 아닌 다른 섬을 만났을 경우
                if( map[nr][nc] != 0 ){
                    // 문제 조건 (다리 길이가 2 이상) 일 경우
                    if(bridgeLength >= 2){
                        // 우선 순위 큐 주입
                        pq.offer(new Edge( nowIslandNum, map[nr][nc], bridgeLength ));
                    } // if
                    // 현재 확인 자표에 다리를 놓았으니 다음 좌표로 이동
                    break;
                }// if

                // 모든 조건에 걸리지 않았으면 바다이므로 다리를 이음
                bridgeLength++;

            }// while

        } // for
    }

    public static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            // 가중치 기준 오름 차순
            return Integer.compare(this.w, o.w);
        }
    }
}
