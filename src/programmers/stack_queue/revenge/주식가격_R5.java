package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class 주식가격_R5 {
    public int[] solution(int[] prices) {

        int pricesSize = prices.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int[] answer = new int[pricesSize];
        for(int i = 0 ; i < pricesSize ; i++){
            while( !stack.isEmpty() && prices[stack.peek()] > prices[i]  ){
                int prevTime = stack.pop();
                answer[prevTime] = i - prevTime;
            } // while
            stack.push(i);
        } // for

        while(!stack.isEmpty()){
            int val = stack.pop();
            answer[val] = pricesSize - 1 - val;
        } // if

        return answer;
    }
}
