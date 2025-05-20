package programmers.brute_force;

public class 최소직사각형 {
    // solution : 명함 번호	가로 길이	세로 길이
    //1	60	50
    //2	30	70
    //3	60	30
    //4	80	40
    // 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다.
    // 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.
    public static void main(String[] args) {
        int[][] sizes = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };
        new 최소직사각형().solution(sizes);
    }
    public int solution(int[][] sizes) {
        int answer = 0;
        return answer;
    }
}
