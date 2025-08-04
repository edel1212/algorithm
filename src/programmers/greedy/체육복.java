package programmers.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 체육복 {
    public static void main(String[] args) {
        System.out.println(new 체육복().solution(5, new int[]{2,4}, new int[]{1,3,5}));
    }
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet    = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        // 1. 초기화
        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);

        // 교집합을 구함
        Set<Integer> overlap = new HashSet<>(lostSet);
        // retainAll을 사용해서 교집합 구함
        overlap.retainAll(reserveSet);
        // 중복 제거
        lostSet.removeAll(overlap);
        reserveSet.removeAll(overlap);

        // 체육복 빌려주기
        for(int r : reserveSet){
            if( lostSet.contains(r -1) ){
                lostSet.remove(r -1);
            } else if( lostSet.contains(r + 1) ){
                lostSet.remove(r +1);
            } // if - else
        } // for

        return n - lostSet.size();
    }
}
