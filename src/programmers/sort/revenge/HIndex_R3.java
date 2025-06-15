package programmers.sort.revenge;

import java.util.Arrays;

public class HIndex_R3 {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        new HIndex_R3().solution(citations);
    }
    public int solution(int[] citations) {

        Arrays.sort(citations);
        int HIndex = citations.length;

        for(int i = 0 ; i < citations.length; i++){
            if( HIndex <= citations[i] ) return HIndex;
        } // for

        return 0;
    }
}
