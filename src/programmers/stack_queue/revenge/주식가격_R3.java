package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 주식가격_R3 {

    // goal : 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return
    public static void main(String[] args){
        int[] prices = {3, 2 , 1};
        new 주식가격_R3().solution(prices);
    }

    public int[] solution(int[] prices) {
        int pricesSize = prices.length;
        int[] answer = new int[pricesSize];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int time = 0 ; time < pricesSize ; time++){

            while (!stack.isEmpty() && prices[time] < prices[stack.peek()]){
                int prevTIme = stack.pop();
                answer[prevTIme] = time - prevTIme;
            }
            stack.push(time);
        } // for

        while (!stack.isEmpty()) {
            int time = stack.pop();
            answer[time] = pricesSize - 1 - time;
        }

        return answer;
    }
}
