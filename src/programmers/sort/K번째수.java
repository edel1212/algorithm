package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class K번째수 {
    public static void main(String[] args){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        new K번째수().solution(array,commands);
    }

    public int[] solution(int[] array, int[][] commands) {
       List<Integer> answer = new ArrayList<>();

       for(int idx = 0 ; idx < commands.length; idx++){

           int i = commands[idx][0];
           int j = commands[idx][1];
           int k = commands[idx][2];

            List<Integer> arr = Arrays.stream(array).boxed().collect(Collectors.toList())
                    .subList(i-1, j);
            arr.sort(Comparator.comparing(Integer::intValue));

            answer.add(arr.get(k-1));

       } // for

       return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
