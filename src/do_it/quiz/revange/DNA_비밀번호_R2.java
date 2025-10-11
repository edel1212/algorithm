package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class DNA_비밀번호_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        // DNA 범위
        int N = Integer.parseInt(tokenizer.nextToken());
        // 비밀번호 범위
        int M = Integer.parseInt(tokenizer.nextToken());

        // DNA Array
        char[] DNA = br.readLine().toCharArray();

        // 최소 통과 알파벳 개수
        int[] minPassCount = new int[4];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i ++){
            minPassCount[i] = Integer.parseInt(tokenizer.nextToken());
        } // for

        // slide window 초기 검사
        int[] windowCount = new int[4];
        // 0 ~ 비밀번호 범위 까지 검사
        for(int i = 0 ; i < M ; i++){
            addSlidWindowCount(windowCount, DNA[i]);
        }// for

        // 정합 판정 비밀번호
        int result = 0;

        // 최초 1회 검사
        if( isValid(windowCount, minPassCount) ) result++;

        for(int i = M; i <N; i++){
            // 다음 인덱스
            addSlidWindowCount(windowCount, DNA[i]);
            // 비밀번호 가장 앞쪽 제거 - 슬라이딩 윈도우 기에 같이 움직임
            removeSlidWindowCount(windowCount, DNA[ i - M ]);
            if( isValid(windowCount, minPassCount) ) result++;
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }


    public static void addSlidWindowCount(int[] windowCount, char dna){
        if ('A' == dna) windowCount[0]++;
        else if('C' == dna) windowCount[1]++;
        else if('G' == dna) windowCount[2]++;
        else if('T' == dna) windowCount[3]++;
    }

    private static void removeSlidWindowCount(int[] windowCount, char dna){
        if ('A' == dna) windowCount[0]--;
        else if('C' == dna) windowCount[1]--;
        else if('G' == dna) windowCount[2]--;
        else if('T' == dna) windowCount[3]--;
    }

    public static boolean isValid(int[] windowCount, int[] minPassCount){
        for(int i = 0 ; i < 4; i++){
            // 최소 사용 개수보다 적게 사용했을 경우
            if(windowCount[i] < minPassCount[i]) return false;
        } // for
        return true;
    }


}
