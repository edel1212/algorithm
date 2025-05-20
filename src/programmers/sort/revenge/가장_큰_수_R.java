package programmers.sort.revenge;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장_큰_수_R {
    public static void main(String[] args){
        int[] numbers = {3, 30, 34, 5, 9};
    }

    public String solution(int[] numbers) {

        String answer = Arrays.stream(numbers).boxed()
                .map(String::valueOf)
                .sorted((a,b)->{
                    String ab = a+b;
                    String ba = b+a;
                    return ba.compareTo(ab);
                }).collect(Collectors.joining());

        if(answer.startsWith("0")) return "0";

        return answer;
    }
}
