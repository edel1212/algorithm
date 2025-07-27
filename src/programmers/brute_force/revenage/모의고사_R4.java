package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.List;

public class 모의고사_R4 {
    public static void main(String[] args) {
        new 모의고사_R4().solution(new int[]{1,2,3,4,5});
    }
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int student1Score = 0;
        int student2Score = 0;
        int student3Score = 0;
        int maxScore = Integer.MIN_VALUE;

        for(int i = 0 ; i < answers.length; i++){
            if( answers[i] == student1[ i % student1.length ]) student1Score++;
            if( answers[i] == student2[ i % student2.length ]) student2Score++;
            if( answers[i] == student3[ i % student3.length ]) student3Score++;
        } //for
        maxScore = Math.max(student1Score, Math.max(student2Score, student3Score));

        List<Integer> answer = new ArrayList<>();
        if( maxScore == student1Score ) answer.add(1);
        if( maxScore == student2Score ) answer.add(2);
        if( maxScore == student3Score ) answer.add(3);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
