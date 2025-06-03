package programmers.brute_force.revenage;

public class 카펫_R {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int totalTile = brown + yellow;

        for(int col = 3 ; col <= totalTile ; col++){
            int row = totalTile / col ;

            // 가로 면적의 최소 개수는 3
            if(row < 3) continue;

            // 조건식 추가 - 가로는 세로길이보다 크다
            if( row >= col ){
                int tmpYellow = ( row - 2 ) * ( col - 2 );
                if( tmpYellow == yellow ){
                    answer[0] = row;
                    answer[1] = col;
                } //  if
            } // if

        } // for

        return new int[]{0,1};
    }
}
