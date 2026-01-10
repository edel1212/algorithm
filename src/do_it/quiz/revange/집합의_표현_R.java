package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 집합의_표현_R {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // index 범위
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 확인 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        A = new int[N + 1];

        for(int i = 0 ;i <= N ;i++) A[i] = i;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int calc = Integer.parseInt(stringTokenizer.nextToken());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            // 합집합 연산일 경우
            if(calc == 0){
                union(a, b);
                continue;
            } //if

            boolean result = find(a) == find(b) ;

            sb.append( result ? "YES" : "NO" );
            sb.append("\n");
        } // for


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        A[fa] = A[fb];
    }

    public static int find(int i){
        if(A[i] == i) return i;
        // 값을 바꿔가며 value Root 노드를 찾아 반환
        return A[i] = find(A[i]);
    }

}
