package programmers.hash.revenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class 완주하지_못한_선수_R {

    // 목적 : participant 중 단 한명의 선수만 완주를 return
    //       - 참여한 선수들의 이름이 담긴 배열 participant. 완주한 선수들의 이름이 담긴 배열 completion
    //       -
    public static void main(String[] args){
        String[] participant = {"marina","marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion  = {"mislav", "stanko", "mislav", "ana"};
        완주하지_못한_선수_R obj = new 완주하지_못한_선수_R();
        System.out.println(obj.solution2(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer;

        Arrays.sort(participant);
        Arrays.sort(completion);

        answer = participant[ participant.length - 1 ];
        for(int i = 0  ; i < completion.length ; i++){
            String player = participant[i];
            String completionPlayer = completion[i];
            if(!completionPlayer.equals(player)) return player;
        }// for

        return answer;
    }

    public String solution2(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Long> completionMap =
                Arrays.asList(completion).stream().collect(Collectors.groupingBy( k ->k , Collectors.counting() ));

        for(String participantPlayer : participant){

            if(completionMap.containsKey(participantPlayer)){
                if( completionMap.get(participantPlayer) < 1 ){
                    return participantPlayer;
                } else{
                    completionMap.put(participantPlayer, completionMap.get(participantPlayer) - 1);
                }// if - else
            } else{
                return participantPlayer;
            } // if - else

        } // loop

        return answer;
    }
}
