package do_it.quiz;

import java.io.*;
import java.util.StringTokenizer;

public class DNA_비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strToken = new StringTokenizer(br.readLine(), " ");
        // DNA 문자 길이
        int S = Integer.parseInt(strToken.nextToken());
        // 비밀번호 범위
        int P = Integer.parseInt(strToken.nextToken());

        // init - 대상
        char[] dna = br.readLine().toCharArray();

        // 최소 들어가야하는 알파벳 개수 [A,C,G,T] - 비밀번호 체크 배열 각 인덱스 뱔로 필요한 개수가 들어 있음
        int[] minCount = new int[4];
        // 비밀번호 내 단어 개수
        strToken = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) minCount[i] = Integer.parseInt(strToken.nextToken());

        // 현재 윈도우 내 문자 개수
        int[] windowCount = new int[4];
        // 초기 윈도우 init - 0 ~ 지정 범위까지
        for(int i = 0 ; i < P ; i ++){
            addChar(windowCount, dna[i]);
        } // for

        int result = 0;
        // 초기 sliding window 배열 체크
        if(isValid(windowCount, minCount)) result++;

        // 비밀번호의 끝 범위를 하나씩 증가 , 가장 앞부분은 제거
        for(int i = P; i < S ; i++){
            // 새로운 문자 추가
            addChar(windowCount, dna[i]);
            // 가장 앞의 문자 제거
            removeChar(windowCount, dna[i - P]);
            if(isValid(windowCount, minCount)) result++;
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void addChar(int[] windowCount, char c){
        if (c == 'A') windowCount[0]++;
        else if (c == 'C') windowCount[1]++;
        else if (c == 'G') windowCount[2]++;
        else if (c == 'T') windowCount[3]++;
    }

    private static void removeChar(int[] windowCount, char c){
        if (c == 'A') windowCount[0]--;
        else if (c == 'C') windowCount[1]--;
        else if (c == 'G') windowCount[2]--;
        else if (c == 'T') windowCount[3]--;
    }

    private static boolean isValid(int[] windowCount, int[] minCount){
        for(int i = 0 ; i < 4; i++){
            if( windowCount[i] < minCount[i] ) return false;
        } // for
        return true;
    }
}
