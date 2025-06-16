package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.List;

public class 모의고사_R3 {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5,};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int student1Score = 0;
        int student2Score = 0;
        int student3Score = 0;
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < answers.length; i++){
            if(  student1[ i % student1.length] == answers[i]  ) student1Score++;
            if(  student2[ i % student2.length] == answers[i]  ) student2Score++;
            if(  student3[ i % student3.length] == answers[i]  ) student3Score++;
        } // for

        int topScore = Math.max(student1Score, Math.max( student3Score, student2Score ));

        if(student1Score == topScore ) result.add(1);
        if(student2Score == topScore ) result.add(2);
        if(student3Score == topScore ) result.add(3);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
