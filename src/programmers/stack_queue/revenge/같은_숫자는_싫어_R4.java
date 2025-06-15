package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class 같은_숫자는_싫어_R4 {

    public static void main(String[] args) {
        new 같은_숫자는_싫어_R4().solution(new int[]{1,2,2,3});
    }
    public int[] solution(int []arr) {

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0 ; i < arr.length; i ++){
            if( !stack.isEmpty() && stack.peek() == arr[i] ) continue;
            stack.push(arr[i]);
        } // for

        int[] answer = new int[stack.size()];

        int i = stack.size() - 1;
        while(!stack.isEmpty()){
            answer[i--] = stack.pop();
        } // while

        return answer;
    }
}
