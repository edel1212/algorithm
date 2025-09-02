package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class DNA_비밀번호_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        // 기본 배열 길이
        int S = Integer.parseInt(stringTokenizer.nextToken());
        // 비밀번호 길이
        int P = Integer.parseInt(stringTokenizer.nextToken());

        // DNA 배얄
        char[] DNA = br.readLine().toCharArray();

        // A, C, G, T 의 최소 통과 카운트
        int[] minPassCount = new int[4];
        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        // 최소 통과 카운트 배열 init
        for(int i = 0 ; i < 4; i++) minPassCount[i] = Integer.parseInt(stringTokenizer.nextToken());

        // P 범위 까지의 초기 배열 생성
        int[] windowCount = new int[4];
        // 초기 P 범위까지의 알파벳 개수
        for(int i = 0 ; i < P; i++){
            // 초기 비밀번호 범위까지의 window 카운트 검사
            addArr(windowCount, DNA[i]);
        } // for


        // 정합 판정 비밀번호
        int result = 0;
        // 초기 값 검사
        if( isValid(windowCount, minPassCount) ) result++;

        for(int i = P; i < S; i++){
            // 다음 인덱스
            addArr(windowCount, DNA[i]);
            // 비밀번호 가장 앞쪽 제거 - 슬라이딩 윈도우 기에 같이 움직임
            removeArr(windowCount, DNA[ i - P ]);
            if( isValid(windowCount, minPassCount) ) result++;
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void addArr(int[] windowCount, char dna){
        if ('A' == dna) windowCount[0]++;
        else if('C' == dna) windowCount[1]++;
        else if('G' == dna) windowCount[2]++;
        else if('T' == dna) windowCount[3]++;
    }

    private static void removeArr(int[] windowCount, char dna){
        if ('A' == dna) windowCount[0]--;
        else if('C' == dna) windowCount[1]--;
        else if('G' == dna) windowCount[2]--;
        else if('T' == dna) windowCount[3]--;
    }

    private static boolean isValid(int[] windowCount, int[] minPassCount){
        for(int i = 0 ; i < 4 ; i++){
            // 최소 커트 라인을 넘지 못할 경우
            if(windowCount[i] < minPassCount[i]) return false;
        } // for
        return true;
    }
}
