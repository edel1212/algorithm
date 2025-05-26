package programmers.brute_force;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    // goal :  종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
    //          - 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
    //              종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성
    // condition : numbers는 길이 1 이상 7 이하인 문자열
    //              - numbers는 0~9까지 숫자만으로 이루어져 있습니다.
    //              - "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
    public static void main(String[] args){
        String numbers = "17";
        new 소수찾기().solution(numbers);
    }

    Set<Integer> numberSet = new HashSet<>();

    // 1 . 받은 문자열 기준으로 만들 수 있는 모든 경우의 숫자의 숫자의 배열로 만듬
    // 2 . 지정 숫자범위까지 loop를 돌면서 소수 인지 체크
    //      - 1과 자기 자신만 맞는지
    //      - ㄴ> 1과 자기자긴의 약수로 만 이뤄져 있는ㅇ지 확인
    public int solution(String numbers) {
        // 번호 조합을 저장할 Set
        generateNumbers("", numbers);

        int answer = 0;
        for (int num : numberSet) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    // 조합 가능한 모든 숫자를 만듬
    /**
     * > 조합 가능한 모든 숫자를 만듬
     *
     * prefix : 지금까지 만든 숫자 조합
     * remaining : 아직 붙일 수 있는 남은 숫자들
     *
     * */
    private void generateNumbers(String prefix, String remaining){
        if(!prefix.isEmpty()) numberSet.add(Integer.parseInt(prefix));

        for(int i = 0 ; i < remaining.length(); i++ ){
            // 숫자 조합
            String pf = prefix + remaining.charAt(i);
            // 처음부터 i까지 + i + 1 부터 전체
            String rm = remaining.substring( 0, i ) + remaining.substring( i +1 );
            generateNumbers( pf, rm);
        } // for
    }

    private boolean isPrime(int num){
        // 1이하 일 경우 소수가 아니다
        if (num < 2) return false;
        // 제곱근을 구함 ( 음수를 주입하 경우 NaN Exception 발생 )
        int sqrt = (int) Math.sqrt(num);
        for( int i = 2; i <= sqrt; i++  ){
            if( num % i == 0 ) return false;
        } //for
        return true;
    }

    /*************************************/
    private void generateNumbers2(String addNum, String remainingNum){
        if(!addNum.isEmpty()) numberSet.add(Integer.parseInt(addNum));

        for(int i = 0 ; i < remainingNum.length(); i ++){
            String makeAddNum = addNum + remainingNum.charAt(i);
            String rem = remainingNum.substring(0,i) + remainingNum.substring(i+2);
            generateNumbers2(makeAddNum, rem);
        } // for

    }

}
