package programmers.brute_force.revenage;


import java.util.HashSet;
import java.util.Set;

public class 소수찾기_R {

    // goal :  종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
    //          - 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
    //              종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성
    // condition : numbers는 길이 1 이상 7 이하인 문자열
    //              - numbers는 0~9까지 숫자만으로 이루어져 있습니다.
    //              - "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
    public static void main(String[] args){
        String numbers = "17";
        new 소수찾기_R().solution(numbers);
    }

    Set<Integer> numSet = new HashSet<>();

    // 1. 전달 받은 문자열을 모든 경우의 숫자로 변경 - 중복 제거를 위해 set 사용
    // 2. 해당 set을 돌며 소수의 개수를 찾는다. ( 약수가 1과 자기 자신인것 )
    public int solution(String numbers) {
        makeNumber("", numbers);

        int answer = 0;
        for (int num : numSet) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    // 소수 검증
    private boolean isPrime(int num){
        if(num < 2 ) return false;
        int sqrt = (int) Math.sqrt( num );
        for( int i = 2; i <= sqrt; i++  ){
            if( num % i == 0 ) return false;
        } // for
        return true;
    }

    private void makeNumber(String addNum, String remainderNum){
        if(!addNum.isEmpty()) numSet.add(Integer.valueOf(addNum));

        for(int i = 0 ; i < remainderNum.length(); i++){
            // 17일 경우
            // idx : 0 일 때 :  "" + "1";
            // idx : 0 일 때 :  "1" + "7";
            // idx : 1 일 때 :  "" + "7";
            // idx : 1 일 때 :  "" + "7";
            String makeAddNum = addNum + remainderNum.charAt(i);

            // idx : 0 일 때 :  "" + "7";
            // idx : 0 일 때 :  "" + "";
            // idx : 1 일 때 :  "1" + "7";
            String makeRemainderNum = remainderNum.substring(0, i)
                    + remainderNum.substring(i + 1);

            makeNumber( makeAddNum, makeRemainderNum );
        } // for
    } //
}
