package programmers.brute_force.revenage;

public class 최소직사각형_R {

    // solution : 명함 번호	가로 길이	세로 길이
    //1	60	50
    //2	30	70
    //3	60	30
    //4	80	40
    // 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다.
    // 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.
    public static void main(String[] args){
        int[][] sizes = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };
        new 최소직사각형_R().solution(sizes);
    }

    // solution :  각각 가장 큰 가로와 가장 큰 세로를 구해여 곱한다.
    //            - 가로와 세로를 회전하는 조건이기에 최대값 최소 값 기준으로 모든 값 비교
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for(int i = 0 ; i < sizes.length ; i++){
            // 가로와 새로를 구분 지어 값을 구할 수 있음
            int max = Math.max( sizes[i][0], sizes[i][1] );
            int min = Math.min( sizes[i][0], sizes[i][1] );

            maxWidth  = Math.max( maxWidth, max );
            maxHeight = Math.max( maxHeight, min );
        } // for

        return maxWidth * maxHeight;
    }
}
