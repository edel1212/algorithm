package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class 주식가격_R {
    // goal : 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return
    public static void main(String[] args){
        int[] prices = {1, 2, 3, 2, 3};
        new 주식가격_R().solution(prices);
    }

    public int[] solution(int[] prices) {

        // 주식의 총 개수
        int pricesSize = prices.length;

        // 결과를 담을 배열을 초기화
        int[] answer = new int[pricesSize];

        // 주식이 떨어지는 시점을 찾기 위한 스택
        Deque<Integer> stack = new ArrayDeque<>();

        for(int time = 0; time < pricesSize ; time++){

            // 주식 가격이 떨어졌을 경우
            while( !stack.isEmpty() && prices[time] < prices[stack.peek()] ){
                int prevTime = stack.pop();
                // 떨어진 친구는 현재 - 과겨의 시간 만큼의 유지 시간을 가짐
                answer[time] = time - prevTime;
            } // while

            stack.push(time);

        } // for

        while (!stack.isEmpty()){
            int time = stack.pop();
            answer[time] = pricesSize - 1 - time;
        } // while

        return answer;
    }
}
