package programmers.brute_force.revenage;

public class 카펫_R4 {
    public int[] solution(int brown, int yellow) {
        int totalCapet = brown + yellow;

        int[] answer = new int[2];
        // 새로는 최소 3부터 시작함 - 갈 노 갈
        for(int col = 3 ; col <= totalCapet; col++ ){
            int row = totalCapet / col;

            if(row >= col){
                int tempYellow = (row-2) * (col-2);
                if(tempYellow == yellow){
                    answer[0] = row;
                    answer[1] = col;
                }
            } // if
        } // for

        return answer;
    }
}
