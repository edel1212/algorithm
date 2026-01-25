package do_it.quiz;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 불우이웃돕기 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // root arr init
        parents = new int[N + 1];
        for(int i = 0 ; i <= N ; i++) parents[i] = i;

        // 1. 간선들을 담을 우선순위 큐 (자동 정렬) - 2차원 배열 사용하면 메모리 초과 성능상 좋지 않음
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int totalSum = 0; // 모든 랜선의 길이 합

        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 한 줄을 통째로 읽음 ("abc...")

            for (int j = 0; j < N; j++) {
                char c = line.charAt(j); // 한 글자씩 떼어냄

                // '0'이면 간선이 없는 것이므로 스킵
                if (c == '0') continue;

                // 문자 -> 숫자 변환 (아까 만든 함수나 로직 사용)
                int w = getWeight(c);

                // 모든 랜선은 일단 총합에 더함 (기부할 때 쓰려고)
                totalSum += w;

                // i와 j가 다를 때만 연결 후보로 넣음 (자기 자신 연결은 MST에 필요 없음)
                if (i != j) {
                    pq.offer(new Edge(i, j, w)); // i번 컴퓨터에서 j번 컴퓨터로, 비용 w
                } // if
            }//for
        } // for

        int usedCount = 0;
        int usedLength = 0;

        // MST
        while(!pq.isEmpty()){
            Edge current = pq.poll();
            if(find(current.s) != find(current.e)){
                union(current.s, current.e);
                usedLength += current.w;
                usedCount++;
                if(usedCount == N - 1) break;
            } // if
        }//for

        if(usedCount != N - 1) {
            bw.write("-1");
        } else{
            bw.write(String.valueOf(totalSum - usedLength));
        } // -if - else


        bw.flush();
        bw.close();
    }


    public static int getWeight(char c) {
        if(c == '0') return 0;

        if (c >= 'a' && c <= 'z') {
            // 소문자인 경우 (1 ~ 26)
            return c - 'a' + 1;
        } else {
            // 대문자인 경우 (27 ~ 52)
            // 'A'는 0이 되므로 +27을 해줌
            return c - 'A' + 27;
        }
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
