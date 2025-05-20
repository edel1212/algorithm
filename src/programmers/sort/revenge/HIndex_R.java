package programmers.sort.revenge;

import java.util.Arrays;

public class HIndex_R {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
    }

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int cnt = citations.length - 1;
        for(int i : citations){
            if(i >= cnt) return i;
        } // for

        return answer;
    }
}
