package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class 최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ;i < N ;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(stringTokenizer.nextToken());
            int v2 = Integer.parseInt(stringTokenizer.nextToken());
            // 큰수를 맞춰서 넣어줌
            int gdcResult = v1 < v2 ? gcd(v2,v1) : gcd(v1,v2);
            // 최소 공배수를 구함 ( 입력값 * 입력값 / 최대 공약수 )
            bw.write(String.valueOf( v1 * v2 / gdcResult ));
            bw.newLine();
        } // for

        bw.flush();
        bw.close();
    }

    public static int gcd(int o1, int o2){
        // Mod 진행
        int mod = o1 % o2;
        // mod 결과가 0일 경우 작은수가 최대 공약수임
        if(mod == 0) return o2;
        // 재귀
        return gcd(o2, mod);
    }

}
