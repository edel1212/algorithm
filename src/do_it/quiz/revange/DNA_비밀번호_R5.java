package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class DNA_비밀번호_R5 {
    static int[] PASS = new int[4];
    static int[] CURRENT_PASS_COUNT = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        // 비밀번호 총 개수
        int S = Integer.parseInt(stringTokenizer.nextToken());
        // 사용 가능한 비밀번호 개수
        int P = Integer.parseInt(stringTokenizer.nextToken());

        char[] C =  br.readLine().toCharArray();

        // A, C, G, T 각각의 필요 개수
        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++){
            PASS[i] = Integer.parseInt(stringTokenizer.nextToken());
        } // for

        // 초기 검사
        for(int i = 0 ; i < P ; i++){
            addCount(C[i]);
        } // for
        int result = 0;
        if(isAllow()) result++;

        int start = 0;
        int end = P;
        while(end < S){
            removeCount(C[start]);
            addCount(C[end]);
            if(isAllow()) result++;
            start++;
            end++;
        } //while

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void addCount(char c){
        if(c == 'A'){
            CURRENT_PASS_COUNT[0]++;
        } else if(c == 'C'){
            CURRENT_PASS_COUNT[1]++;
        } else if(c == 'G'){
            CURRENT_PASS_COUNT[2]++;
        } else {
            CURRENT_PASS_COUNT[3]++;
        }
    }

    public static void removeCount(char c){
        if(c == 'A'){
            CURRENT_PASS_COUNT[0]--;
        } else if(c == 'C'){
            CURRENT_PASS_COUNT[1]--;
        } else if(c == 'G'){
            CURRENT_PASS_COUNT[2]--;
        } else {
            CURRENT_PASS_COUNT[3]--;
        }
    }

    public static boolean isAllow(){
        for(int i = 0 ; i < 4 ; i++){
            int pass = PASS[i];
            int current = CURRENT_PASS_COUNT[i];
            if(current < pass) return false;
        } // for
        return true;
    }
}
