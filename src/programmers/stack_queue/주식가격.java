package programmers.stack_queue;

import java.util.*;

public class 주식가격 {
    // goal : 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return
    // condition : - prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
    //             - prices의 길이는 2 이상 100,000 이하입니다.
    public static void main(String[] args){
        int[] prices = {1,2,3,2,3};
        new 주식가격().solution(prices);
    }

    public int[] solution(int[] prices){
        int wrapSize = prices.length;
        int[] answer = new int[wrapSize];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int index = 0 ; index < wrapSize ; index++){

            while( !stack.isEmpty() && prices[index] < prices[stack.peek()] ){

                System.out.println("prices["+index+"] :: " + prices[index]);
                System.out.println("prices["+stack.peek()+"] :: " + prices[stack.peek()]);

                int prevIndex = stack.pop();
                answer[prevIndex] = index - prevIndex;
            }// loop
            stack.push(index);

        } // for

        while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = wrapSize - 1 - index;
        } // loop

        return answer;
    }
}
