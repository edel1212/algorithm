package programmers.brute_force.revenage;

public class 카펫_R2 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int totalCapet = brown + yellow;

        for( int col = 3 ; col <= totalCapet ; col++ ){
            int row = totalCapet / 3;

            if( row < 3  ) continue;

            if( row >= col ){
                int yellowTmp = ( row -2 ) * ( col * 2 );
                if( yellow == yellowTmp ){
                    answer[0] = row;
                    answer[1] = col;
                    return answer;
                } // if
            } // if
        } // for

        return answer;
    }
}
