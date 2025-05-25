package programmers.brute_force;

import java.util.*;

public class 모의고사 {
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
        //int[] answer = {1,3,2,4,2};
        new 모의고사().solution(answer);
    }

    // 0. 순번과 정답 개수를 확인 할 수 있는 map 준비
    // 1. 1번 : n/10 -1
    // 2. 문제 정답 loop
    public int[] solution(int[] answers) {
        Integer[] oneArr = {1, 2, 3, 4, 5};
        Integer[] twoArr = {2,1, 2,3, 2,4, 2,5};
        Integer[] threeArr = {3,3, 1,1, 2,2, 4,4, 5,5};

        int[] score = new int[3];
        for(int i = 0 ; i < answers.length ; i++){
            // 6 -> 0 , 11 - > 0 , 16 -> 0
            if( answers[i] == oneArr[ i % oneArr.length] ) score[0]++ ;
            if( answers[i] == oneArr[ i % twoArr.length] ) score[1]++ ;
            if( answers[i] == oneArr[ i % threeArr.length] ) score[2]++ ;
        } // for

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 3 ; i ++){
            if( maxScore == score[i] ) result.add( i + 1);
        } // for

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
