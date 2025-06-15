package programmers.sort.revenge;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장_큰_수_R3 {
    public String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
                .boxed()
                .map(String::valueOf)
                .sorted((a,b)->{
                    String ab = a+b;
                    String ba = b+a;
                    return ba.compareTo(ab);
                }).collect(Collectors.joining());

        if(result.startsWith("0")) return "0";

        return result;
    }
}
