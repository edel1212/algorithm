package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 집합의_표현 {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        // 원소의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 질의의 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // 대표 노드 값 init
        parent = new int[ N + 1 ];
        for(int i = 0 ; i <= N ; i++){
            parent[i] = i ;
        } // for

        // 공식을 찾음
        for(int i = 0 ; i < M ; i++){
            stringTokenizer = new StringTokenizer(br.readLine());

            // 0은 합집합 연산
            // 1은  find 연산
            int question = Integer.parseInt(stringTokenizer.nextToken());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            if(question == 0){
                union(a,b);
                continue;
            } // if

            String result = check(a,b) ? "YES" : "NO";
            bw.write(result);
            bw.newLine();
        }// for

        bw.flush();
        bw.close();
    }

    public static void union(int a , int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }// if
    }

    // 재귀를 통해 find를 함
    public static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static boolean check(int a ,int b){
        a = find(a);
        b = find(b);
        if( a == b) return true;
        return false;
    }



}
