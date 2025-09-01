package do_it.quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

        // init
        char[] dna = br.readLine().toCharArray();

        // 최소 들어가야하는 알파벳 개수 [A,C,G,T]
        int[] minCount = new int[4];
        for (int i = 0; i < 4; i++) minCount[i] = Integer.parseInt(strToken.nextToken());

        // 현재 slideWindow로 가져온 배열의 알파벳 개수
        int[] windowCount = new int[4]; // 현재 윈도우 내 문자 개수
        int result = 0;

        // 비밀번호 내 단어 개수
        strToken = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(strToken.nextToken());
        int C = Integer.parseInt(strToken.nextToken());
        int G = Integer.parseInt(strToken.nextToken());
        int T = Integer.parseInt(strToken.nextToken());

        int left = 0;
        int right = P;
        int count = 0;
        while(right <= S){

            List<Character> subArray = arr.subList(left, right);

            long getA = subArray.stream().filter(i -> i == 'A').count();
            long getC = subArray.stream().filter(i -> i == 'C').count();
            long getG = subArray.stream().filter(i -> i == 'G').count();
            long getT = subArray.stream().filter(i -> i == 'T').count();
            if( A == getA && C == getC && G == getG && T == getT ){
                count++;
            } // if

            left ++;
            right++;
        } // while

        bw.write(String.valueOf(count));
        bw.flush();
    }
}
