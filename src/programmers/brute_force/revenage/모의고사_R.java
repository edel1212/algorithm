package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.List;

public class 모의고사_R {

    // goal : 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
    // 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 returns
    // - 1번 : 1, 2, 3, 4, 5.... 1 ~ 5
    // - 2번 : 2,1 2,3 2,4, 2,5.... 2,1 ~ 2,5
    // - 3번 : 3,3, 1,1 2,2 4,4 5,5 .... 3,3 ~ 5,5
    //
    // condition : 시험은 최대 10,000 문제로 구성
    // - 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    // - 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬
    public static void main(String[] args){
        int[] answer = {1,2,3,4,5};
        new 모의고사_R().solution(answer);
    }

    public int[] solution(int[] answers) {
        Integer[] oneArr = {1, 2, 3, 4, 5};
        Integer[] twoArr = {2,1, 2,3, 2,4, 2,5};
        Integer[] threeArr = {3,3, 1,1, 2,2, 4,4, 5,5};

        int[] scores = new int[3];

        for(int i = 0 ; i < answers.length ; i ++){
            if( answers[i] == oneArr[ i % oneArr.length ] ) scores[0]++;
            if( answers[i] == twoArr[ i % twoArr.length ] ) scores[1]++;
            if( answers[i] == threeArr[ i % threeArr.length ] ) scores[2]++;
        } // for

        int maxScore = Math.max( scores[0], Math.max( scores[1], scores[2] ) );

        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i < scores.length; i++){
            if( maxScore == scores[i] ) result.add(i+1);
        } // for

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
