package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 완주하지_못한_선수_R3 {

    public static void main(String[] args) {
        String[] participant = {"marina","marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion  = {"mislav", "stanko", "mislav", "ana"};
        new 완주하지_못한_선수_R3().solution(participant, completion);
    }

    public String solution(String[] participant, String[] completion) {

        Map<String, Long> participantMap = Arrays.stream(participant).collect(Collectors.groupingBy(k->k,Collectors.counting()));

        // 완주한 사람
        for(String goal : completion){

            if(participantMap.containsKey(goal)){
                participantMap.put(goal, participantMap.get(goal) - 1 );
                if(participantMap.get(goal) < 1) participantMap.remove(goal);
            } // if

        } // for

        String answer = "";
        for(String k : participantMap.keySet()){
            answer = k;
        } // for

        return answer;
    }
}
