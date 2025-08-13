package programmers.greedy.revenge;

import java.util.*;
import java.util.stream.Collectors;

public class 체육복_R2 {
    public static void main(String[] args) {
        new 체육복_R2().solution(5, new int[]{2,4,3}, new int[]{1,3,5});
    }
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = Arrays.stream(lost).boxed().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> reserveSet = Arrays.stream(reserve).boxed().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        // 공집합을 구함 ( 가져왔지만 잃어버린 애 )
        Set<Integer> retainSet =  new HashSet<>(reserveSet);
        retainSet.retainAll(lostSet);

        // 중복 제거
        lostSet.removeAll(retainSet);
        reserveSet.removeAll(retainSet);

        List<Integer> sortedReserve = new ArrayList<>(reserveSet);
        Collections.sort(sortedReserve);
        for(int i : sortedReserve) {
            if(lostSet.contains(i - 1)){
                lostSet.remove(i - 1);
            } else if(lostSet.contains(i + 1)){
                lostSet.remove(i + 1);
            } // if - else
        } // for

        return n - lostSet.size();
    }
}
