package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class 주식가격_R4 {
    // goal : 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return
    public static void main(String[] args){
        int[] prices = {3, 4 , 2, 5};
        new 주식가격_R4().solution(prices);
    }

    // solution :  내 뒤의 값을 버티먄 다음 단계로 넘어감 단계마다 +1
    //            - 스택 생성
    //            - 시간만큼 for문
    //            - 현재값 - 과거값 비교 : 과거가 더 작을 경우 해당 값의 시간 자정
    //            - 남은 stack에 남은 애들은 멈추지 않은 애들 길이만큼 시간 지정
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];

        // 바로 직전을 비교하는건 stack을 사용하는게 효율적임
        Deque<Integer> stack = new ArrayDeque<>();
        for(int timeIndex = 0 ; timeIndex < size; timeIndex++){

            while(!stack.isEmpty() && prices[timeIndex] < prices[stack.peek()] ){
                int prevTimeIndex = stack.pop();
                answer[prevTimeIndex] = timeIndex - prevTimeIndex;
            } // while

            stack.push(timeIndex);
        } // for


        while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = size - 1 - index;
        } // while


        return answer;
    }

}
