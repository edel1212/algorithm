package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class 최소공배수_R {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 개수
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 유클리드 호재법을 통해 최소 공배수를 구하는 공식
            int result = a * b / gcd(a, b);
            bw.write(String.valueOf(  result  ));
            bw.newLine();
        }// for

        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        // b를 앞으로 -> 자리 바꿈
        return gcd( b , a % b);
    }
}
