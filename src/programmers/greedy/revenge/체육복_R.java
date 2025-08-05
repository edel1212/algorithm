package programmers.greedy.revenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class 체육복_R {
    public static void main(String[] args) {
        new 체육복_R().solution(5, new int[]{2,4,3}, new int[]{1,3,5});
    }
    public int solution(int n, int[] lost, int[] reserve) {

        // 읽어버린 학생
        Set<Integer> lostSet = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        // 가져온 학생
        Set<Integer> reserveSet = Arrays.stream(reserve).boxed().collect(Collectors.toSet());

        // 교집합을 구함
        Set<Integer> overlap = new HashSet<>(lostSet);
        // retainAll을 사용해서 교집합 구함
        overlap.retainAll(reserveSet);

        lostSet.removeAll(overlap);
        reserveSet.removeAll(overlap);


        for(int r : reserveSet){
            if(lostSet.contains( r + 1)){
                lostSet.remove(r + 1);
            } else if(lostSet.contains( r - 1)){
                lostSet.remove(r - 1);
            }
        } //for

        return n - lostSet.size();
    }
}
