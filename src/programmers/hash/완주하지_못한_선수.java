package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 완주하지_못한_선수 {
    // 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
    // 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
    // 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
    //
    //제한사항
    //마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
    //completion의 길이는 participant의 길이보다 1 작습니다.
    //참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
    //참가자 중에는 동명이인이 있을 수 있습니다.
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        Solution solution = new Solution();
        String result = solution.solution4(participant, completion);
        System.out.println(result);
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        List<String> sortPart = Arrays.asList(participant)
                .stream().sorted().collect(Collectors.toList());
        List<String> sortComp= Arrays.asList(completion)
                .stream().sorted().collect(Collectors.toList());
        String answer = sortPart.get(sortPart.size()-1);

        for(int i = 0 ; i < sortComp.size() ; i++){
            if(!sortPart.get(i).equals(sortComp.get(i))){
                answer = sortPart.get(i);
                break;
            } // if
        } // for

        return answer;
    }

    public String solution2(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        String answer = participant[participant.length -1];

        for(int i = 0 ; i < completion.length ; i++){
            if(!completion[i].equals(participant[i])){
                answer = participant[i];
                break;
            } // if
        } // for

        return answer;
    }

    public String solution3(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for(String key : participant){
            int value = !map.containsKey(key)? 1 :  map.get(key) + 1;
            map.put(key, value);
        } // loop

        for(String part : participant){
            if(!map.containsKey(part)){
                answer = part;
                break;
            } else {
                int value = map.get(part);
                if(value == 0){
                    answer = part;
                    break;
                } // if
                map.put(part, value - 1);
            }; // if - else
        } // loop

        return answer;
    }

    public String solution4(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> participantMap = new HashMap<>();

        for(String key : participant){
//            int value = !participantMap.containsKey(key)? 1 :  participantMap.get(key) + 1;
//            participantMap.put(key, value);
              participantMap.put(key, participantMap.getOrDefault(key, 0) + 1);
        } // loop

        for(String completionStr : completion){
            participantMap.put(completionStr, participantMap.get(completionStr) - 1);
        } // loop

        for(String k : participantMap.keySet()){
            if(participantMap.get(k) > 0){
                answer = k;
                break;
            } // if
        } // loop

        return answer;
    }
}