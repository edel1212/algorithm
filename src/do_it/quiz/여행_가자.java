package do_it.quiz;

import java.io.*;
import java.util.*;

public class 여행_가자 {
    // 부모 배열
    static int[] parent;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시 개수
        int N = Integer.parseInt(br.readLine());
        // 여행 계획에 속한 도시 수
        int M = Integer.parseInt(br.readLine());

        // parent init
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)  parent[i] = i; // 처음에는 자기 자신이 부모(대표)임

        boolean isPossible = true;
        bw.write(isPossible ? "YES" : "NO");
        bw.flush();
        bw.close();
    }


    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        // 대표가 서로 다를 경우 다른 경로 하나를 하나로 이어 붙여줌
        if(rootA != rootB) parent[rootA] = rootB;
    }

    public static int find(int i){
        if(i == parent[i]) return i;
        // 경로 압축
        return parent[i] = find(i);
    }

}
