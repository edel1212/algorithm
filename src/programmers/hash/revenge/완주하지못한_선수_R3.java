package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 완주하지못한_선수_R3 {
    public static void main(String[] args){
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        new 완주하지못한_선수_R3().solution(participant, completion);
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Long> map = Arrays.stream(participant)
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        for(String player : completion){
            if( !map.containsKey(player)) return player;
            map.put( player, map.get(player) -1 );
        }


        return answer;
    }
}
