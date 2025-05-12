package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 같은_숫자는_싫어_R3 {
    public static void main(String[] args){
        int[] arr = { 4,4,1,1,3,3,0,1,1 };
        new 같은_숫자는_싫어_R3().solution(arr);
    }

    public int[] solution(int []arr) {

        Deque<Integer> stack = new ArrayDeque<>();

        for(int item : arr){
            if( !stack.isEmpty() && stack.peek() == item ) continue;
            stack.push(item);
        } // for


        int[] answer = new int[stack.size()];

        int index = stack.size() - 1;
        while(!stack.isEmpty()){
            answer[index] = stack.pop();
            index--;
        }

        return answer;
    }
}
