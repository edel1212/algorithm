package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.List;

public class 모의고사_R2 {

    public static void main(String[] args){
        new 모의고사_R2().solution(new int[]{1,2,3,4,5});
    }
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        List<Integer> answer = new ArrayList<>();

        int player1 = 0;
        int player2 = 0;
        int player3 = 0;
        for(int i = 0; i < answers.length; i++){
            if(  a[i % a.length]  == answers[i] ) player1++;
            if(  b[i % b.length]  == answers[i] ) player2++;
            if(  c[i % c.length]  == answers[i] ) player3++;
        } // for
        int maxScore = Math.max(player1, Math.max(player2, player3));

        if(maxScore == player1) answer.add(1);
        if(maxScore == player2) answer.add(2);
        if(maxScore == player3) answer.add(3);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
