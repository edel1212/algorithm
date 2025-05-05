package programmers.stack_queue;

import java.util.*;

public class 주식가격 {
    // goal : 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return
    // condition : - prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
    //             - prices의 길이는 2 이상 100,000 이하입니다.
    public static void main(String[] args){
        int[] prices = {1,5,3};
        new 주식가격().solution(prices);
    }

    public int[] solution(int[] prices){
        // 주식 가격 총 개수
        int priceSize = prices.length;

        // 결과를 담을 배열. 각 인덱스 i에는 prices[i]가 버틴 시간(초)이 들어감
        int[] answer = new int[priceSize];

        // 인덱스를 저장할 스택. 주식 가격이 떨어지는 시점을 찾기 위해 사용
        Deque<Integer> stack = new ArrayDeque<>();

        // 0초부터 시작
        // 전체 주식을 순회하기 위함
        for (int index = 0; index < priceSize; index++) {

            // 현재 가격(prices[index])이 이전 가격(prices[stack.peek()])보다 낮으면,
            // 가격이 떨어졌다는 뜻 → 그 이전 주식은 여기서 끝났다고 판단
            while (!stack.isEmpty() && prices[index] < prices[stack.peek()]) {
                int prevIndex = stack.pop(); // 떨어진 주식의 시작 시점
                // 떨어지기 전까지 버틴 시간 = 현재 시간 - 시작 시간
                answer[prevIndex] = index - prevIndex;
            }

            // 스택에 현재 시점 index 추가
            stack.push(index);
        }

        // 스택에 남아 있는 인덱스들은 끝까지 가격이 떨어지지 않은 것
        while (!stack.isEmpty()) {
            int index = stack.pop();
            // 떨어지지 않고 끝까지 갔으므로 버틴 시간 = 마지막 인덱스 - 현재 인덱스
            answer[index] = priceSize - 1 - index;
        }

        return answer;
    }

    public int[] solution2(int[] prices){
        int priceSize = prices.length;
        int answer[] = new int[priceSize];

        // 주식을 담을 스택
        Deque<Integer> stack = new ArrayDeque<>();

        // 전체 주식 개수만큼 순회
        for(int index = 0 ; index < priceSize ; index++){

            while(!stack.isEmpty() && prices[index] < prices[stack.peek()]){ // 가격이 떨어질 경우임 - 현재 < 과거 [ 과거가 더 크면 떨어진거임 ]
                int failPriceIndex = stack.pop();
                answer[failPriceIndex] = index - failPriceIndex;
            } // while

            // 주식의 순서대로 값을 넣어줌
            stack.push(index);
        } // for

        // 떨어저지 않은 주식들 시간 계산
        while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = priceSize - 1 - index;
        } // while

        return answer;
    }

}
