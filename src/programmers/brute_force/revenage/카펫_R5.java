package programmers.brute_force.revenage;

public class 카펫_R5 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

        // 두 수를 더해서 최대 면적을 구함
        // 가로를 기준으로 완전 탐색 시작 ( 시작 값은 3 이유는 가운데 노랑색은 무조건 들어가기 때문임 )
        // 세로 값을 구함 ( 총면적 / 가로 ) = 세로값
        // if문 생성 가로 길이는 무조건 세로보다 같거나 커야함
        // 노랑색 면적을 구함 세로 -2 * 가로 -2 값

        int totalCapet = brown + yellow;

        for(int row  = 3 ; row <=totalCapet ; row++ ){
            int col = totalCapet / row;
            if(col <= row){
                int yellowTmp = (row-2) * (col-2);
                if(yellow == yellowTmp){
                    answer[0] = row;
                    answer[1] = col;
                } // if
            } // if
        } // for

        return answer;
    }
}
