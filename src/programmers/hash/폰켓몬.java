package programmers.hash;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        폰켓몬 obj = new 폰켓몬();
        System.out.println(obj.solution(nums));
    }

    public int solution(int[] nums) {
        int answer = 0;

        // 문제 : 가장 다양한 수로 포켓몬을 고를 수 있는 방법
        // 전제 조건 :  받은 배열의 N/2

        // 1. 배열을 2로 나눠서 가지 수를 고른다.
        // 2. 대상 배열의 중복을 제거한다.
        // 3 . 첫번째 아이템을 key 로 잡고 value 에는 가장 다양했던 종류의 size를 넣는다.
        // 4 . key를 돌면서 value의 size가 가장 높은것을 찾는다.
        // 5 . 반환한다.

        return answer;
    }
}

