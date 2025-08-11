package programmers.greedy;

public class 조이스틱 {
    public static void main(String[] args) {
        new 조이스틱().solution("CCC");
    }
    public int solution(String name) {
        int upDown = 0;

        // 상,하 최소 값 계산
        for(char c : name.toCharArray()){
            // 입력 받은 값 기준 A와 떨어진 거리 계산
            int diff        = c - 'A';
            // 뒤에서 부터 계산
            int reverseDiff = 26 - diff;
            // 가장 가까운 범위를 사용 하여 answer 저장
            upDown += Math.min(diff, reverseDiff);
        } // for

        // 좌,우 최소 값 계산
        int len = name.length();
        // 최악의 수를 정의하기 위해 가장 끝의 경우를 두고 시작
        int move = len - 1;
        // 문자열의 길이 만큼 검사
        for (int rightSteps = 0; rightSteps < len; rightSteps++) {

            // 다음 칸 이동
            int nextNonAIndex = rightSteps + 1;
            // 연속된 'A' 구간의 시작 지점 찾기
            while (nextNonAIndex < len && name.charAt(nextNonAIndex) == 'A') {
                nextNonAIndex++;
            }

            // 오른쪽으로 갔다가 왼쪽으로 돌아오는 경우의 이동 거리
            int goRightThenLeft = rightSteps                      // 오른쪽으로 이동한 칸 수
                    + (len - nextNonAIndex)                      // 남은 칸 수 (끝에서 왼쪽으로 가야 하는 부분)
                    + Math.min(rightSteps, len - nextNonAIndex); // 되돌아갈 때 짧은 방향 선택

            // 최소 이동 거리 갱신
            move = Math.min(move, goRightThenLeft);
        }

        return upDown + move;
    }

}
