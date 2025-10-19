package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class DNA_비밀번호_R4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 임의의 문자열 길이
        int S = Integer.parseInt(stringTokenizer.nextToken());
        // 비밀번호 길이
        int P = Integer.parseInt(stringTokenizer.nextToken());
        // 임의의 문자열 배열
        char[] A = br.readLine().toCharArray();
        // 최소 패스 카운트
        int[] minPassCount = new int[4];
        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++) minPassCount[i] = Integer.parseInt(stringTokenizer.nextToken());

        int count = 0;
        int[] passCount = new int[4];
        for(int i = 0 ; i < P; i++){
            addCount(A[i], passCount);
        } //for
        if(isValidate(minPassCount, passCount)) count++;

        // 남은 범위 이동
        for(int i = P; i < S ; i++){
            removeCount(A[i - P], passCount);
            addCount(A[i], passCount);
            if (isValidate(minPassCount, passCount)) count++;
        } // for

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    public static void addCount(char c, int[] passCount){
        if(c == 'A') passCount[0]++;
        else if(c == 'C') passCount[1]++;
        else if(c == 'G') passCount[2]++;
        else if(c == 'T') passCount[3]++;
    }

    public static void removeCount(char c, int[] passCount){
        if(c == 'A') passCount[0]--;
        else if(c == 'C') passCount[1]--;
        else if(c == 'G') passCount[2]--;
        else if(c == 'T') passCount[3]--;
    }

    public static boolean isValidate(int[] minPassCount, int[] passCount){
        for(int i = 0 ; i < 4 ; i++){
            if(minPassCount[i] > passCount[i]) return false;
        }// for
        return true;
    }
}
