package programmers.greedy.revenge;

public class 조이스틱_R {
    public static void main(String[] args) {
        new 조이스틱_R().solution("JANAAAN");
    }
    public int solution(String name) {

        int upDownCount = 0;
        for(int c : name.toCharArray()){
            // A ~ 지정 값 의 차이 개수
            int diffCount = c - 'A';
            // 뒤에서 부터 진행 했을 경우 ( 총 개수 - 앞에서 진행했을 경우 값 )
            int reverseCount = 26 - diffCount;
            // 가장 낮은 값을 사용함
            upDownCount += Math.min(diffCount, reverseCount);
        } // for

        // 알파벳의 개수를 구함
        int nameSize = name.length();
        // 좌, 우 최소 이동 횟수 ( 첫 시작을 제외 하므로 -1 )
        int minLeftRightMove = nameSize - 1;

        for(int currentIndex = 0 ; currentIndex < nameSize; currentIndex++){

            // 다음 인덱스
            int nextIndex = currentIndex + 1;
            // 다음 확인 값이 'A'일 경우 Index ++
            while( nextIndex < nameSize && name.charAt(nextIndex) == 'A' ){
                nextIndex ++;
            } // while

            // A를 건너뛴 나머지 거리
            int remainderRightMove = nameSize - nextIndex;

            int totalMove =
                            currentIndex + remainderRightMove               // 왼쪽으로 이동 거리 값
                            + Math.min(currentIndex, remainderRightMove) ;  // 되돌아올 때 더 짧은 쪽으로 이동

            minLeftRightMove = Math.min(totalMove, minLeftRightMove);

        } // for

        return upDownCount + minLeftRightMove;
    }
}
