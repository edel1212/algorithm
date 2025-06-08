package programmers.sort.revenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class K번째_수_R2 {

    public static void main(String[] args){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        new K번째_수_R2().solution(array, commands);
    }

    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for(int[] item : commands){
            int i = item[0];
            int j = item[1];
            int k = item[2];
            List<Integer> arr = Arrays.stream(array)
                    .boxed()
                    .collect(Collectors.toList())
                    .subList(i-1, j)
                    ;
            arr.sort(Comparator.comparingInt(a -> a));
            answer.add(arr.get(k - 1));
        } // for

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
