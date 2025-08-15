package programmers.greedy.revenge;

import java.util.*;
import java.util.stream.Collectors;

public class 체육복_R3 {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        Set<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toSet());
        Set<Integer> retainList = new HashSet<>(reserveList);
        retainList.retainAll(lostList);

        lostList.retainAll(retainList);
        reserveList.retainAll(retainList);

        List<Integer> re = new ArrayList(reserveList);
        Collections.sort(re);
        for(int r : re){
            if(lostList.contains(r - 1)){
                lostList.remove(r -1 );
            } else if(lostList.contains(r + 1)){
                lostList.remove(r +1 );
            } // if - else
        } // for

        return n - lostList.size();
    }
}
