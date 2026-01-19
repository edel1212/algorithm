package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 오민식의_고민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시 수
        int N = Integer.parseInt(st.nextToken());
        // 시작 도시
        int sCity = Integer.parseInt(st.nextToken());
        // 도착 도시
        int eCity = Integer.parseInt(st.nextToken());
        // 교통 수단
        int M = Integer.parseInt(st.nextToken());

        // 최단 거리
        long[] distance = new long[N];
        // 기존 벨만 포드와 다르게 Min 값으로 초기화
        Arrays.fill(distance, Long.MIN_VALUE);

        // 간선 기준 배열
        Edge[] edges = new Edge[M];
        for(int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            // injection data
            edges[i] = new Edge(start, end, price);
        } // for

        // 각 도시마다 벌 수 있는 금액 (도시 번호는 0부터 시작함)
        long[] cityMoney = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< N ; i++){
            cityMoney[i] = Integer.parseInt(st.nextToken());
        }// for

        /***
         * 변형된 벨만 포크 알고리즘 시작 초기 값이 0 이 아닌 도시시작 값
         */
        distance[sCity] = cityMoney[sCity];

        // 어째서 N -1 이 아닌 N + 100 으로 진행 이유 ? 임의의 넉넉한 값을 넣어서 사이클이 생기는 부분을 찾기 위함임
        for(int i = 0 ; i < N + 100 ; i++){
            // 간선의 개수만큼 loop
            for(int j = 0 ; j < M ; j++){
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;

                if(distance[start] == Long.MIN_VALUE){          // 출발 노드가 방문하지 않은 노드라면 스킵
                    continue;
                } else if(distance[start] == Long.MAX_VALUE){   // 출발 노드가 양수 사이클에 연결된 노드라면 종료 노드도 연결 업데이트 이유 ? A가 이미 무한대로 돈을 벌수 있는 구간이기에 연결된 end까지 전파해주는 것
                    distance[end] = Long.MAX_VALUE;
                } else {
                    //  도착 도시 보다 출발 도시 금액까지의 + 해당 도시에서 벌 수 있는 돈 - 사용 금액
                    long makeMoney = distance[start] + cityMoney[end] - price;
                    if( distance[end] < makeMoney){  // 더 돈을 벌 수있는 곳이라면 업데이트
                        distance[end] = makeMoney;

                        // ✅ 핵심 로직 이론상 N-1일 때 더이상 업데이트가 안되야하지만 업데아트가 된다는건 돈을 무한으로 벌 수 있단 의미이기 때문임
                        if(i >= N -1) distance[end] = Long.MAX_VALUE;
                    }// if - else if
                } // if - else
            }// for
        } //for

        String result = String.valueOf(distance[eCity]);
        if(distance[eCity] == Long.MIN_VALUE){ // 도착 자체가 불가능한 곳
            result = "gg";
        } else if(distance[eCity] == Long.MAX_VALUE){
            result = "Gee";
        } // if - else

        bw.write(result);
        bw.flush();
        bw.close();
    }

    public static class Edge{
        int start;
        int end;
        int price;

        public Edge(int start , int end, int price){
            this.start = start;
            this.end = end;
            this.price = price;
        }
    }

}
