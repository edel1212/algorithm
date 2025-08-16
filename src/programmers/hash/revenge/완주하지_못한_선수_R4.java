package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 완주하지_못한_선수_R4 {

    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i = 0 ; i < completion.length; i++){
            if( !participant[i].equals(completion[i]) ) return participant[i];
        } // for

        return participant[participant.length -1];
    }


    public String solution2(String[] participant, String[] completion) {

        Map<String, Long> participantMap = Arrays.stream(participant)
                        .collect(Collectors.groupingBy( key-> key, Collectors.counting() ));

        for(String completedPlayer :  completion){

            if(participantMap.containsKey(completedPlayer)){
                participantMap.put( completedPlayer, participantMap.get(completedPlayer) - 1 );
            } // if

            if(participantMap.get(completedPlayer) < 1) participantMap.remove(completedPlayer);

        } // for



        return participantMap.keySet().stream().findFirst().get();
    }
}
