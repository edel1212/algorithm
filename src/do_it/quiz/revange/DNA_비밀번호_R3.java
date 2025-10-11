package do_it.quiz.revange;

import java.io.*;
import java.util.StringTokenizer;

public class DNA_비밀번호_R3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(tokenizer.nextToken());
        int P = Integer.parseInt(tokenizer.nextToken());

        char[] DNA = br.readLine().toCharArray();

        int[] minPassCount = new int[4];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++){
            minPassCount[i] = Integer.parseInt(tokenizer.nextToken());
        } // for

        int[] windowCount = new int[4];
        for(int i = 0 ; i < P ; i++){
            addWindowArr(windowCount, DNA[i]);
        } // for

        int result = 0;
        if(isValid(windowCount, minPassCount)) result++;

        // 남은 범위 이동하며 조회
        for(int i = P; i < S ; i++){
            removeWindowArr(windowCount, DNA[i - P]);
            addWindowArr(windowCount, DNA[i]);
            if(isValid(windowCount, minPassCount)) result++;
        } // for

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void addWindowArr(int[] windowCount, char dna){
        if('A' == dna) windowCount[0]++;
        else if ('C' == dna) windowCount[1]++;
        else if ('G' == dna) windowCount[2]++;
        else if ('T' == dna) windowCount[3]++;
    }

    public static void removeWindowArr(int[] windowCount, char dna){
        if('A' == dna) windowCount[0]--;
        else if ('C' == dna) windowCount[1]--;
        else if ('G' == dna) windowCount[2]--;
        else if ('T' == dna) windowCount[3]--;
    }

    public static boolean isValid(int[] windowCount, int[] minPassCount){
        for(int i = 0 ; i < 4 ; i++){
            if(windowCount[i] < minPassCount[i]) return false;
        } // for
        return true;
    }
}
