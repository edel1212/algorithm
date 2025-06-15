package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class 주식가격_R7 {

    public static void main(String[] args) {
        new 주식가격_R7().solution(new int[]{1, 2, 3, 2, 3});
    }

    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < prices.length; i++){

            // 과거가 더 클 경우
            while( !stack.isEmpty() && prices[stack.peek()] > prices[i] ){
                int fail = stack.pop();
                answer[fail] = i - fail;
            } // while

            stack.push(i);
        } // for

        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = prices.length - 1 - idx;
        } // while

        return answer;
    }

}
