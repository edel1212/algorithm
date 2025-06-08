package programmers.sort.revenge;

import java.util.Arrays;

public class HIndex_R2 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int size = citations.length;

        int answer = 0;
        for(int i = 0 ; i <  citations.length ; i++){
            int hIndex = size - i;
            if(hIndex <= citations[i]) return hIndex;
        } //for

        return answer;
    }
}
