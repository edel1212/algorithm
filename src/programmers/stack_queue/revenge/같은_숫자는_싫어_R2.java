package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 같은_숫자는_싫어_R2 {
    public static void main(String[] args){
        int[] arr = { 4,4,1,1,3,3,0,1,1 };
        new 같은_숫자는_싫어_R2().solution(arr);
    }
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i : arr) {
            if (!stack.isEmpty() && stack.peek() == i) continue;
            stack.push(i);
        }

        int[] answer = new int[stack.size()];
        int size = stack.size() - 1;
        while (!stack.isEmpty()) {
            answer[size] = stack.pop();
            size--;
        } // loop
        return answer;
    }
}
