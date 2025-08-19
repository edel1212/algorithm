package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class 같은_숫자는_싫어_R5 {
    public static void main(String[] args) {
        new 같은_숫자는_싫어_R5().solution(new int[]{1,1,3,3,0,1,1});
    }
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i : arr){
            if(!stack.isEmpty()){
                int peek = stack.peek();
                if(peek == i) stack.pop();
            } // if
            stack.push(i);
        }// for

        int[] answer = new int[stack.size()];
        for(int i = stack.size() - 1 ; i >= 0; i--){
            answer[i] = stack.pop();
        } // for

        return answer;
    }
}
