package programmers.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장_큰_수 {
    public static void main(String[] args){
        int[] numbers = {3, 30, 34, 5, 9};
        new 가장_큰_수().solution(numbers);
    }

    public String solution(int[] numbers) {
        String answer;

        Integer[] arr = Arrays.stream(numbers).boxed().toArray(n -> new Integer[n]);
        Arrays.sort(arr, (a, b) -> {
            String ab = a.toString() + b;
            String ba = b.toString() + a;
            return ba.compareTo(ab);  // 내림차순 정렬
        });

        // 모든 값이 0인 경우 처리 (예: [0, 0, 0])
        if (arr[0] == 0) return "0";

        answer = Arrays.stream(arr).map(String::valueOf).collect(Collectors.joining());

        System.out.println(answer);

        return answer;
    }


    static int getFirstDigit(int n) {
        while (n >= 10) n /= 10;
        return n;
    }
}
