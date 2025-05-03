package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 완주하지_못한_선수_R2 {
    // goal :  단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주
    //         마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의
    //         이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return
    // condition : 참가자 중에는 동명이인이 있을 수 있습니다.
    //            - 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
    public static void main(String[] args){
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        new 완주하지_못한_선수_R2().solution( participant, completion );
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Long> participantMap =  Arrays.asList(participant).stream()
                .collect(Collectors.groupingBy( n -> n , Collectors.counting()  ));

        for( String completionPlayer : completion ){
            if( !participantMap.containsKey(completionPlayer) ) return completionPlayer;
            Long peopleCnt = participantMap.get(completionPlayer);
            participantMap.put(completionPlayer, peopleCnt - 1 );
        } // for

        for(String player : participantMap.keySet()){

            Long peopleCnt = participantMap.get(player);

            if( peopleCnt > 0 ) return player;

        } // for

        return answer;
    }
}
