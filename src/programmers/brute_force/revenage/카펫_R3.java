package programmers.brute_force.revenage;

public class 카펫_R3 {
    public int[] solution(int brown, int yellow) {

        int totalCapet = brown + yellow;

        int[] answer = new int[2];
        for(int col = 3 ; col <= totalCapet ; col++){
            int row = totalCapet / col;
            if(3 > row) continue;

            if(row >= col){
                int yellowExtend = ( row - 2 ) * (col -2);
                if(yellow == yellowExtend){
                    answer[0] = row;
                    answer[1] = col;
                    return answer;
                }
            } // if

        } // for

        return answer;
    }
}
